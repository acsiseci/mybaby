package com.mybaby.app.controller;


import com.mybaby.app.domain.Parent;
import com.mybaby.app.domain.Story;
import com.mybaby.app.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ParentController(ParentRepository parentRepository,
                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.parentRepository = parentRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody Parent parent) {
        parent.setPassword(bCryptPasswordEncoder.encode(parent.getPassword()));
        parentRepository.save(parent);
    }


    @GetMapping
    public List<Parent> findAllStory() {
        return parentRepository.findAll();
    }
}
