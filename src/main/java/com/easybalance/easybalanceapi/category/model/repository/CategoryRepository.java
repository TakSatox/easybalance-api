package com.easybalance.easybalanceapi.category.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybalance.easybalanceapi.category.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
