package com.easybalance.easybalanceapi.category.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.category.model.Category;
import com.easybalance.easybalanceapi.category.model.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

}
