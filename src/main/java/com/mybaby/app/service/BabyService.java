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
import com.mybaby.app.security.UserPrincipal;
import com.mybaby.app.validator.SaveBabyValidator;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class BabyService {

    private static final String AGENT_NOT_FOUND = "Agent not found";
    private final BabyRepository babyRepository;
    private final BabyParentRepository babyParentRepository;
    private final SaveBabyValidator saveBabyValidator;
    private final BabyDTOConverter babyDTOConverter;
    private final ParentRepository parentRepository;
    private final ParentService parentService;

    public BabyService(BabyRepository babyRepository, BabyParentRepository babyParentRepository, SaveBabyValidator saveBabyValidator, BabyDTOConverter babyDTOConverter, ParentRepository parentRepository, ParentService parentService) {
        this.babyRepository = babyRepository;
        this.babyParentRepository = babyParentRepository;
        this.parentRepository = parentRepository;
        this.saveBabyValidator = saveBabyValidator;
        this.babyDTOConverter = babyDTOConverter;
        this.parentService = parentService;
    }


    public BabyResponse getBabies(UserPrincipal currentUser) {
        List<Baby> babies = parentService.findById(currentUser.getId()).getBabies();
        List<BabyDTO> babyDTOS = babyDTOConverter.convert(babies);
        return BabyResponse.create(babyDTOS);
    }



    public void saveBaby(BabyRequest request, UserPrincipal currentUser) {
        saveBabyValidator.validate(request);
        Parent parent = parentService.findById(currentUser.getId());
        Baby baby = babyDTOConverter.convert(request);
        baby.addBabyParent(parent);
        babyRepository.save(baby);
    }

    public void updateBaby(Long babyId, BabyRequest request) {
        Baby baby = findById(babyId);
        baby.setName(request.getName());
        baby.setGender(request.getGender());
        baby.setBirthday(request.getBirthday());
        babyRepository.save(baby);
    }


    public void delete(Long id) {
        babyRepository.deleteById(id);
    }

    public Baby findById(long id) {
        return babyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "baby not found"));
    }



}
