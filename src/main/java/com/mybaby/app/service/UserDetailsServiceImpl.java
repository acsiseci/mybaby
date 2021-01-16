package com.mybaby.app.service;


import com.mybaby.app.domain.Parent;
import com.mybaby.app.repository.ParentRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private ParentRepository parentRepository;

    public UserDetailsServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Parent developer = parentRepository.findByUsername(username);
        if (developer == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(developer.getUsername(), developer.getPassword(), emptyList());
    }
}