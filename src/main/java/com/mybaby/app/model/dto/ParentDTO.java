package com.mybaby.app.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParentDTO {

    private String username;
    private String password;
    private String name;
    private String familyCode;
    private List<BabyDTO> babyList;


    public List<BabyDTO> getBabyList() {
        return babyList;
    }

    public void setBabyList(List<BabyDTO> babyList) {
        this.babyList = babyList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

}
