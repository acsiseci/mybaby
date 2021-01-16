package com.mybaby.app.service;

import com.mybaby.app.domain.Baby;
import com.mybaby.app.domain.Parent;
import com.mybaby.app.domain.Story;
import com.mybaby.app.model.BabyModel;
import com.mybaby.app.model.BabyResponse;
import com.mybaby.app.repository.BabyRepository;
import com.mybaby.app.repository.ParentRepository;
import com.mybaby.app.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BabyService {

    @Autowired
    BabyRepository babyRepository;

    @Autowired
    ParentRepository parentRepository;

    public BabyResponse getAll()
    {
        List<Baby> allBabies = babyRepository.findAll();
        BabyResponse babyResponse = new BabyResponse();
        List<BabyModel> babyModels = new ArrayList<>();

        for (Baby baby : allBabies) {
            BabyModel babyModel = new BabyModel();
            babyModel.setName(baby.getName());
            babyModel.setBirthday(baby.getBirthday());
            babyModel.setGender(baby.getGender());
            babyModels.add(babyModel);
        }
        babyResponse.setBabyModels(babyModels);
        return babyResponse;

    }


    public void save(Baby baby) {
        List<Parent> parentList = new ArrayList<>();
        parentList.add(parentRepository.findByUsername("test1"));
        //baby.setParents(parentList);
        babyRepository.save(baby);
    }

}
