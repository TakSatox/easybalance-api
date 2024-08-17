package com.easybalance.easybalanceapi.user.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.easybalance.easybalanceapi.user.api.request.CreateUserRequest;
import com.easybalance.easybalanceapi.user.api.response.UserResponse;
import com.easybalance.easybalanceapi.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
@Validated
public class UserController {
    
    private final UserService service;


    @Operation(summary = "List Users", description = "List all users")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping
    public List<UserResponse> list() {
        return UserResponse.fromList(service.getAll());
    }

    @Operation(summary = "Get User", description = "Get user info")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/{email}")
    public UserResponse get(
        @PathVariable("email") String email
    ) {
        return UserResponse.from(service.getByEmail(email));
    }

    @Operation(summary = "Add User", description = "Add a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "CREATED")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return UserResponse.from(service.save(request));
    }

    @Operation(summary = "Remove User", description = "Remove a user given an email")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

}
