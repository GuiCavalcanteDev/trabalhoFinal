package com.weatherapp.security;


import com.weatherapp.exceptions.EventNotFoundException;
import com.weatherapp.model.user.UserModel;
import com.weatherapp.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    
    private final IUserRepository repository;

    public CustomUserDetailsService(IUserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserModel user = this.repository.findByEmail(username).orElseThrow(() -> new EventNotFoundException(""));
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}