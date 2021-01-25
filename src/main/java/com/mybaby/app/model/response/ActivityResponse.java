package com.mybaby.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybaby.app.domain.Activity;

import java.util.List;

public class ActivityResponse {
    @JsonProperty("activities")
    private final List<Activity> activities;
    private final Long babyId;


    public ActivityResponse(List<Activity> activities, Long babyId) {
        this.activities = activities;
        this.babyId = babyId;
    }
}
