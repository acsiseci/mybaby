package com.mybaby.app.controller;

import com.mybaby.app.model.request.ParentRequest;
import com.mybaby.app.model.response.ParentResponse;
import com.mybaby.app.service.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("parent")
public class ParentController {

    private final ParentService parentService;

    @PostMapping
    public void save(@RequestBody ParentRequest request) {
        parentService.save(request);
    }

    @GetMapping
    public ParentResponse getBabies() {
        return parentService.getParents();
    }
}
