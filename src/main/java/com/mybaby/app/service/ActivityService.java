package com.mybaby.app.service;


import com.mybaby.app.domain.Activity;
import com.mybaby.app.domain.Baby;
import com.mybaby.app.model.dto.ActivityDTO;
import com.mybaby.app.model.dto.BabyDTO;
import com.mybaby.app.model.request.ActivityRequest;
import com.mybaby.app.model.response.ActivityResponse;
import com.mybaby.app.model.response.BabyResponse;
import com.mybaby.app.repository.ActivityRepository;
import com.mybaby.app.repository.BabyRepository;
import com.mybaby.app.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final BabyRepository babyRepository;
    private final BabyService babyService;

    public ActivityService(ActivityRepository activityRepository, BabyRepository babyRepository, BabyService babyService) {
        this.activityRepository = activityRepository;
        this.babyRepository = babyRepository;
        this.babyService = babyService;
    }

    public void saveActivity(ActivityRequest request, UserPrincipal currentUser) {
        Activity activity = new Activity();
        activity.setDate(request.getDate());
        activity.setActivity(request.getActivity());
        activity.setDetail(request.getDetail());
        activity.setType(request.getType());
        activity.setBaby(babyService.findById(request.getBabyId()));
        activityRepository.save(activity);
    }


    public ArrayList<ActivityDTO> getActivityList(UserPrincipal currentUser) {
        List<Baby> babyList =  babyService.getBabiesList(currentUser);
        ArrayList<ActivityDTO> activityList = new ArrayList<>();
        for (int i = 0; i < babyList.size(); i++) {
            List<Activity> activities = activityRepository.findAllByBabyEquals(babyList.get(i));
            ActivityDTO activityDTO = new ActivityDTO ();
            activityDTO.setActivities(activities);
            activityDTO.setBabyId(babyList.get(i).getId());
            activityList.add(activityDTO);
        }
        return activityList;
    }
}