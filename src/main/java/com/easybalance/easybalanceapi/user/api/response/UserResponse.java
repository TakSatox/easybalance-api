package com.easybalance.easybalanceapi.user.api.response;

import java.util.List;

import com.easybalance.easybalanceapi.user.model.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "UserResponse", description = "User Response")
public class UserResponse {

    @Schema(description = "User ID", example = "1")
    private Long id;

    @Schema(description = "User Name", example = "John Doe")
    private String name;

    @Schema(description = "User Email", example = "johndoe@example.com")
    private String email;
    

    public static UserResponse from(User entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
            .build();
    }


    public static List<UserResponse> fromList(List<User> entities) {
        return entities.stream().map(UserResponse::from).toList();
    }

}
