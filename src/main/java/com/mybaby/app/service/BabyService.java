package com.mybaby.app.service;

import com.mybaby.app.converter.BabyDTOConverter;
import com.mybaby.app.domain.Baby;
import com.mybaby.app.domain.BabyParent;
import com.mybaby.app.domain.Parent;
import com.mybaby.app.model.dto.BabyDTO;
import com.mybaby.app.model.request.BabyRequest;
import com.mybaby.app.model.response.BabyResponse;
import com.mybaby.app.repository.BabyParentRepository;
import com.mybaby.app.repository.BabyRepository;
import com.mybaby.app.repository.ParentRepository;
import com.mybaby.app.validator.SaveBabyValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;


@Service
public class BabyService {

    private static final String AGENT_NOT_FOUND = "Agent not found";
    private final BabyRepository babyRepository;
    private final BabyParentRepository babyParentRepository;
    private final SaveBabyValidator saveBabyValidator;
    private final BabyDTOConverter babyDTOConverter;
    private final ParentRepository parentRepository;

    public BabyService(BabyRepository babyRepository, BabyParentRepository babyParentRepository, SaveBabyValidator saveBabyValidator, BabyDTOConverter babyDTOConverter, ParentRepository parentRepository) {
        this.babyRepository = babyRepository;
        this.babyParentRepository = babyParentRepository;
        this.parentRepository = parentRepository;

        this.saveBabyValidator = saveBabyValidator;
        this.babyDTOConverter = babyDTOConverter;
    }

    public BabyResponse getBabies() {
        List<Baby> babies = babyRepository.findAll();
        List<BabyDTO> babyDTOS = babyDTOConverter.convert(babies);
        return BabyResponse.create(babyDTOS);
    }

    public void save(BabyRequest request) {
        saveBabyValidator.validate(request);
        Baby baby = babyDTOConverter.convert(request);
        List<Parent> parents = new ArrayList<>();
        BabyParent babyParent = new BabyParent();

        babyParent.setBaby(baby);
        babyParent.setParent(parentRepository.findAll().get(2));

        baby.setParents(parents);
        babyRepository.save(baby);
        babyParentRepository.save(babyParent);
    }

    public void delete(Long id) {
        babyRepository.deleteById(id);
    }



}
