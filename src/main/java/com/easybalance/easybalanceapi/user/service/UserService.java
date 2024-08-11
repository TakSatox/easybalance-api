package com.easybalance.easybalanceapi.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.user.api.controller.CreateUserRequest;
import com.easybalance.easybalanceapi.user.model.User;
import com.easybalance.easybalanceapi.user.model.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository repository;

    public User save(CreateUserRequest request) {
        return repository.save(
            User.builder()
                .name(request.getName())
                .email(request.getEmail())
            .build()
        );
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteByEmail(String email) {
        User user = getByEmail(email);
        repository.delete(user);
    }

}
