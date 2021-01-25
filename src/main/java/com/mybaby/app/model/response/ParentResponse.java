package com.mybaby.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybaby.app.model.dto.ParentDTO;

import java.util.List;

public class ParentResponse {
    @JsonProperty("parents")
    private final List<ParentDTO> babyDTOList;


    public ParentResponse(List<ParentDTO> babyDTOList) {
        this.babyDTOList = babyDTOList;
    }

    public static ParentResponse create(List<ParentDTO> parentDTOList){
        return new ParentResponse(parentDTOList);
    }

}
