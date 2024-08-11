package com.easybalance.easybalanceapi.user.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easybalance.easybalanceapi.category.api.response.CategoryExpensesByUserResponse;
import com.easybalance.easybalanceapi.category.service.ListCategoryExpensesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Expenses")
public class UserExpensesController {
    
    private final ListCategoryExpensesService service;

    @Operation(summary = "List User Categories Expenses", description = "List user categories expenses by date and user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/{id}/categories")
    public List<CategoryExpensesByUserResponse> listCategoriesByUser(
        @PathVariable("id") Long id,
        @RequestParam Integer month,
        @RequestParam Integer year

    ) {
        return CategoryExpensesByUserResponse.fromList(service.getCategoryExpensesByUser(id, month, year));
    }

}
