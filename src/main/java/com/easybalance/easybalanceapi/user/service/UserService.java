package com.easybalance.easybalanceapi.user.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.easybalance.easybalanceapi.user.api.request.CreateUserRequest;
import com.easybalance.easybalanceapi.user.model.entity.User;
import com.easybalance.easybalanceapi.user.model.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository repository;

    public User save(CreateUserRequest request) {
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }

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
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
