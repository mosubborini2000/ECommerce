package com.example.ECommerce.service.categoryService;


import com.example.ECommerce.dto.categoryDto.CategoryRequest;
import com.example.ECommerce.dto.categoryDto.CategoryResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
     void createCategory(CategoryRequest categoryRequest);
     ResponseEntity<List<CategoryResponse>> getAllCaegory();
     void updateCategory(Long categoryId,CategoryRequest category);


     boolean findById(Long categoryId);
}
