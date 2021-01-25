package com.mybaby.app.controller;

import com.mybaby.app.model.dto.ActivityDTO;
import com.mybaby.app.model.request.ActivityRequest;

import com.mybaby.app.security.CurrentUser;
import com.mybaby.app.security.UserPrincipal;
import com.mybaby.app.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("api/activity")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public void saveActivity(@RequestBody ActivityRequest request, @CurrentUser UserPrincipal currentUser) {
        activityService.saveActivity(request,currentUser);
    }


    @GetMapping
    public ArrayList<ActivityDTO> getActivityList(@CurrentUser UserPrincipal currentUser) {
        return activityService.getActivityList(currentUser);
    }
}
