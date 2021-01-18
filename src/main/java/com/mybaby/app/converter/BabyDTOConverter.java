package com.mybaby.app.converter;

import com.mybaby.app.domain.Baby;
import com.mybaby.app.domain.Parent;
import com.mybaby.app.model.dto.BabyDTO;
import com.mybaby.app.model.dto.ParentDTO;
import com.mybaby.app.model.request.BabyRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BabyDTOConverter implements Converter<Baby, BabyDTO> {

    @Override
    public BabyDTO convert(Baby baby) {
        BabyDTO babyDTO = new BabyDTO();
        babyDTO.setName(baby.getName());
        babyDTO.setBirthday(baby.getBirthday());
        babyDTO.setGender(baby.getGender());
        List<ParentDTO> parentDTOS = convertParent(baby.getParents());
        babyDTO.setParents(parentDTOS);
        return babyDTO;
    }


    public Baby convert(BabyRequest request) {
        Baby baby = new Baby();
        baby.setName(request.getName());
        baby.setGender(request.getGender());
        baby.setBirthday(request.getBirthday());
        return baby;
    }

    private List<ParentDTO> convertParent(List<Parent> parents) {
        List<ParentDTO> parentDTOS = new ArrayList<>();
        for (Parent parent : parents) {
            ParentDTO parentDTO = new ParentDTO();
            parentDTO.setName(parent.getName());
            parentDTO.setFamilyCode(parent.getFamilyCode());
            parentDTOS.add(parentDTO);
        }
        return parentDTOS;
    }
}
