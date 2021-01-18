package com.mybaby.app.model.request;

import java.util.List;

public class BabyRequest {

    private String gender;
    private String name;
    private String birthday;
    private List<ParentRequest> parents;

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

    public List<ParentRequest> getParents() {
        return parents;
    }

    public void setParents(List<ParentRequest> parents) {
        this.parents = parents;
    }
}
