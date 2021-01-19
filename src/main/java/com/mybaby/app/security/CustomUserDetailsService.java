package com.mybaby.app.security;

import com.mybaby.app.domain.Parent;
import com.mybaby.app.exception.NotFoundException;
import com.mybaby.app.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private ParentRepository userRepository;

    @Autowired
    public CustomUserDetailsService(ParentRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) {
        Parent parent = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new NotFoundException("User not found [email: " + email + "]")
                );

        return UserPrincipal.create(parent);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Parent user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found [id: " + id + "]")
        );

        return UserPrincipal.create(user);
    }
}