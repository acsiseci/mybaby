package com.mybaby.app.converter;

import com.mybaby.app.domain.BabyParent;
import com.mybaby.app.domain.Parent;
import com.mybaby.app.model.dto.BabyDTO;
import com.mybaby.app.model.dto.ParentDTO;
import com.mybaby.app.model.request.ParentRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentsDTOConverter implements Converter<Parent, ParentDTO> {

    @Override
    public ParentDTO convert(Parent parent) {
        ParentDTO parentDTO = new ParentDTO();
        parentDTO.setFamilyCode(parent.getFamilyCode());
        parentDTO.setName(parent.getName());
        parentDTO.setBabyList(convertBaby(parent.getBabyParents()));
        return parentDTO;
    }

    public Parent convert(ParentRequest parentDTO) {
        Parent parent = new Parent();
        parent.setUsername(parentDTO.getUsername());
        parent.setPassword(parentDTO.getPassword());
        parent.setFamilyCode(parentDTO.getFamilyCode());
        parent.setName(parentDTO.getName());
        return parent;
    }

    private List<BabyDTO> convertBaby(List<BabyParent> babies) {
        List<BabyDTO> babyDTOS = new ArrayList<>();
        for (BabyParent babyParent : babies) {
            BabyDTO babyDTO = new BabyDTO();
            babyDTO.setName(babyParent.getBaby().getName());
            babyDTO.setGender(babyParent.getBaby().getGender());
            babyDTO.setBirthday(babyParent.getBaby().getBirthday());
            babyDTOS.add(babyDTO);
        }
        return babyDTOS;
    }
}
