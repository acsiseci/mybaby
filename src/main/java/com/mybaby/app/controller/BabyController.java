package com.mybaby.app.controller;

import com.mybaby.app.domain.Baby;
import com.mybaby.app.model.request.BabyRequest;
import com.mybaby.app.model.response.BabyResponse;
import com.mybaby.app.security.CurrentUser;
import com.mybaby.app.security.UserPrincipal;
import com.mybaby.app.service.BabyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/baby")
public class BabyController {

    private final BabyService babyService;

    @PostMapping
    public void saveBaby(@RequestBody BabyRequest request, @CurrentUser UserPrincipal currentUser) {
        babyService.saveBaby(request,currentUser);
    }


    @PutMapping("/{babyId}")
    private void updateBaby(@PathVariable("babyId") Long babyId,@RequestBody BabyRequest request,@CurrentUser UserPrincipal currentUser) {
        babyService.updateBaby(babyId,request);


    }

    @GetMapping
    public BabyResponse getBabies(@CurrentUser UserPrincipal currentUser) {
        return babyService.getBabies(currentUser);
    }


    @DeleteMapping("/{babyId}")
    private void deleteBaby(@PathVariable("babyId") Long babyId) {
        babyService.delete(babyId);
    }



}
