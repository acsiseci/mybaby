package com.mybaby.app.model.dto;

import com.mybaby.app.domain.Activity;

import java.util.List;

public class ActivityDTO {

    private List<Activity> activities;
    private Long babyId;

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Long getBabyId() {
        return babyId;
    }

    public void setBabyId(Long babyId) {
        this.babyId = babyId;
    }


}
