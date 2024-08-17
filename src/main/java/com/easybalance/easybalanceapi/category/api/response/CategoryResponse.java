package com.easybalance.easybalanceapi.category.api.response;

import java.util.List;

import com.easybalance.easybalanceapi.category.model.entity.Category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "CategoryResponse", description = "Category Response")
public class CategoryResponse {
    
    @Schema(description = "Category ID", example = "1")
    private Long id;
    
    @Schema(description = "Category Title", example = "Food")
    private String title;


    public static CategoryResponse from(Category entity) {
        return CategoryResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
            .build();
    }

    public static List<CategoryResponse> fromList(List<Category> entities) {
        return entities.stream().map(CategoryResponse::from).toList();
    }
}
