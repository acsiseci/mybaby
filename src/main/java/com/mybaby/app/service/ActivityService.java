package com.mybaby.app.service;


import com.mybaby.app.domain.Activity;
import com.mybaby.app.model.request.ActivityRequest;
import com.mybaby.app.repository.ActivityRepository;
import com.mybaby.app.repository.BabyRepository;
import com.mybaby.app.security.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
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
}