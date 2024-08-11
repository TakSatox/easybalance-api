package com.easybalance.easybalanceapi.category.api.response;


import java.util.List;

import com.easybalance.easybalanceapi.category.model.dto.UserCategoryExpensesDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class CategoryExpensesByUserResponse {
    
    @Schema(description = "Category ID", example = "1")
    private Long id;
    
    @Schema(description = "Category Title", example = "Food")
    private String title;

    @Schema(description = "Category Total Expenses", example = "100.00")
    private Float totalValue;
    
    public static CategoryExpensesByUserResponse from(UserCategoryExpensesDto dto) {
        return CategoryExpensesByUserResponse.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .totalValue(dto.getTotalValue())
            .build();
    }

    public static List<CategoryExpensesByUserResponse> fromList(List<UserCategoryExpensesDto> dtos) {
        return dtos.stream().map(CategoryExpensesByUserResponse::from).toList();
    }

}
