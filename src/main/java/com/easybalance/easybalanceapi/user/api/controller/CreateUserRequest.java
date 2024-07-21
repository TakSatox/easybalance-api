package com.easybalance.easybalanceapi.user.api.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@Schema(name = "CreateUserRequest", description = "Create User Request")
public class CreateUserRequest {
    
    @NonNull
    @Schema(description = "User name", example = "John Doe")
    private String name;

    @NonNull
    @Schema(description = "User email", example = "johndoe@example.com")
    private String email;

}
