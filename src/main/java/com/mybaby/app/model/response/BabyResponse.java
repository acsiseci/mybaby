package com.mybaby.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybaby.app.model.dto.BabyDTO;

import java.util.List;

public class BabyResponse {

    @JsonProperty("babies")
    private final List<BabyDTO> babyDTOList;

    private BabyResponse(List<BabyDTO> babyDTOList) {
        this.babyDTOList = babyDTOList;
    }



    public static BabyResponse create(List<BabyDTO> babyDTOList){
        return new BabyResponse(babyDTOList);
    }

    public List<BabyDTO> getBabyDTOList() {
        return babyDTOList;
    }
}
