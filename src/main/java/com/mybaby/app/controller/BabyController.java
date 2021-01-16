package com.mybaby.app.controller;

import com.mybaby.app.domain.Baby;
import com.mybaby.app.domain.Story;
import com.mybaby.app.model.BabyResponse;
import com.mybaby.app.service.BabyService;
import com.mybaby.app.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/baby")
public class BabyController {

    @Autowired
    private BabyService babyService;

    @GetMapping
    public BabyResponse findAllBabys() {
        return babyService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Baby baby) {
        babyService.save(baby);
    }
}
