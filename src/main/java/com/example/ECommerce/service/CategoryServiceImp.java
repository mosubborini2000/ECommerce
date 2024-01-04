package com.example.ECommerce.service;

import com.example.ECommerce.Repository.CategoryRepository;
import com.example.ECommerce.model.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
   private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(CategoryEntity category) {
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryEntity> getAllCaegory() {
        return categoryRepository.findAll();

    }


}
