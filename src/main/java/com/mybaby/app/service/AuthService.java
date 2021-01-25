package com.mybaby.app.service;

import com.mybaby.app.domain.Parent;
import com.mybaby.app.exception.ConflictException;
import com.mybaby.app.model.request.LoginRequest;
import com.mybaby.app.model.request.SignUpAndSaveBabyRequest;
import com.mybaby.app.model.request.SignUpRequest;
import com.mybaby.app.model.response.JwtAuthenticationResponse;
import com.mybaby.app.repository.ParentRepository;
import com.mybaby.app.security.JwtTokenProvider;
import com.mybaby.app.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    private AuthenticationManager authenticationManager;
    private ParentRepository parentRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider tokenProvider;
    private BabyService babyService;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, ParentRepository parentRepository, PasswordEncoder passwordEncoder, JwtTokenProvider tokenProvider,BabyService babyService) {
        this.authenticationManager = authenticationManager;
        this.parentRepository = parentRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.babyService = babyService;
    }

    public JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        log.info("User with [email: {}] has logged in", userPrincipal.getEmail());
        return new JwtAuthenticationResponse(jwt);
    }

    public Long registerUser(SignUpRequest signUpRequest) {
        if(parentRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new ConflictException("Email [email: " + signUpRequest.getEmail() + "] is already taken");
        }
        Parent user = new Parent();
        user.setEmail(signUpRequest.getEmail());
        user.setFamilyCode(signUpRequest.getFamilyCode());
        user.setName(signUpRequest.getName());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        log.info("Successfully registered user with [email: {}]", user.getEmail());
        return parentRepository.save(user).getId();
    }

    public Long registerUserAndSaveBabies(SignUpAndSaveBabyRequest signUpAndBabyRequest) {
        if(parentRepository.existsByEmail(signUpAndBabyRequest.getEmail())) {
            throw new ConflictException("Email [email: " + signUpAndBabyRequest.getEmail() + "] is already taken");
        }
        Parent user = new Parent();
        user.setEmail(signUpAndBabyRequest.getEmail());
        user.setFamilyCode(signUpAndBabyRequest.getFamilyCode());
        user.setName(signUpAndBabyRequest.getName());
        user.setPassword(passwordEncoder.encode(signUpAndBabyRequest.getPassword()));
        log.info("Successfully registered user with [email: {}]", user.getEmail());
        Long userId = parentRepository.save(user).getId();
        for (int i = 0; i < signUpAndBabyRequest.getBaby().size(); i++) {
            babyService.saveBaby(signUpAndBabyRequest.getBaby().get(i),userId);
        }
        return userId;

    }
}
