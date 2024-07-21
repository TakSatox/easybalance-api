package com.easybalance.easybalanceapi.user.service;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.user.model.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository userRepository;

}
