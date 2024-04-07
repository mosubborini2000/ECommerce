package com.example.ECommerce.service;


import com.example.ECommerce.dto.CategoryRequest;
import com.example.ECommerce.dto.CategoryResponse;
import com.example.ECommerce.model.CategoryEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
     void createCategory(CategoryRequest categoryRequest);
     ResponseEntity<List<CategoryResponse>> getAllCaegory();
     void updateCategory(Long categoryId,CategoryRequest category);


     boolean findById(Long categoryId);
}
