package com.example.springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.springboot.springsecurity.model.User;
import com.example.springboot.springsecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}