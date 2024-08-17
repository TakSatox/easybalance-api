package com.easybalance.easybalanceapi.category.model.dto;

import com.easybalance.easybalanceapi.user.model.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserCategoryExpensesDto {
    
    @Schema(description = "Category ID", example = "1")
    private Long id;
    
    @Schema(description = "Category Title", example = "Food")
    private String title;

    @Schema(description = "Category Total Expenses", example = "100.00")
    private Float totalValue;

    @Schema(description = "User")
    private User user;

}
