package com.mybaby.app.controller;

import com.mybaby.app.model.request.LoginRequest;
import com.mybaby.app.model.request.SignUpAndSaveBabyRequest;
import com.mybaby.app.model.request.SignUpRequest;
import com.mybaby.app.model.response.JwtAuthenticationResponse;
import com.mybaby.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public Long register(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }

    @PostMapping("/signup-savebaby")
    public Long registers(@Valid @RequestBody SignUpAndSaveBabyRequest signUpAndBabyRequest) {
        return authService.registerUserAndSaveBabies(signUpAndBabyRequest);
    }


}