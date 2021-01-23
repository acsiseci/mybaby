package com.mybaby.app.service;

import com.mybaby.app.converter.BabyDTOConverter;
import com.mybaby.app.converter.ParentsDTOConverter;
import com.mybaby.app.domain.Baby;
import com.mybaby.app.domain.Parent;
import com.mybaby.app.model.dto.BabyDTO;
import com.mybaby.app.model.dto.ParentDTO;
import com.mybaby.app.model.request.ParentRequest;
import com.mybaby.app.model.response.ParentResponse;
import com.mybaby.app.repository.BabyRepository;
import com.mybaby.app.repository.ParentRepository;
import com.mybaby.app.validator.SaveBabyValidator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParentService {

    private final ParentRepository parentRepository;
    private final ParentsDTOConverter parentsDTOConverter;


    public ParentService(ParentRepository parentRepository, ParentsDTOConverter parentsDTOConverter, BabyRepository babyRepository, SaveBabyValidator saveBabyValidator, BabyDTOConverter babyDTOConverter) {
        this.parentRepository = parentRepository;
        this.parentsDTOConverter = parentsDTOConverter;

    }

    public ParentResponse getParents() {
        List<Parent> parents = parentRepository.findAll();
        List<ParentDTO> parentDTOS = parentsDTOConverter.convert(parents);
        return ParentResponse.create(parentDTOS);
    }

    public void save(ParentRequest request) {
        Parent parent = parentsDTOConverter.convert(request);
        parentRepository.save(parent);
    }

    public Parent findById(long id) {
        return parentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "parent not found"));
    }
}