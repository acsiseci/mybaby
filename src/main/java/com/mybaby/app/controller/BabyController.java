package com.mybaby.app.controller;

import com.mybaby.app.model.request.BabyRequest;
import com.mybaby.app.model.response.BabyResponse;
import com.mybaby.app.service.BabyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("baby")
public class BabyController {

    private final BabyService babyService;

    @PostMapping
    public void save(@RequestBody BabyRequest request) {
        babyService.save(request);
    }


    @DeleteMapping("/{storyId}")
    private void deleteBook(@PathVariable("storyId") Long storyId)
    {
        babyService.delete(storyId);
    }


    @GetMapping
    public BabyResponse getBabies() {
        return babyService.getBabies();
    }
}
