package com.mybaby.app.model;

import java.util.List;

public class BabyModel {
    private String gender;
    private String name;
    private String birthday;
    private List<ParentModel> parentModelList;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<ParentModel> getParentModelList() {
        return parentModelList;
    }

    public void setParentModelList(List<ParentModel> parentModelList) {
        this.parentModelList = parentModelList;
    }



}
