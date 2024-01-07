package com.example.ECommerce.service;


import com.example.ECommerce.model.CategoryEntity;

import java.util.List;

public interface CategoryService {
     void createCategory(CategoryEntity category);
     List<CategoryEntity> getAllCaegory();
     void updateCategory(Long categoryId,CategoryEntity category);


     boolean findById(Long categoryId);
}
