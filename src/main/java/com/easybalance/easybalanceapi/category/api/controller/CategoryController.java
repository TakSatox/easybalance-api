package com.easybalance.easybalanceapi.category.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybalance.easybalanceapi.category.api.response.CategoryResponse;
import com.easybalance.easybalanceapi.category.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Category API")
@Validated
public class CategoryController {
    
    private final CategoryService categoryService;


    @Operation(summary = "List Categories", description = "List all categories")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping
    public List<CategoryResponse> listCategories() {
        return CategoryResponse.fromList(categoryService.getCategories());
    }


}
