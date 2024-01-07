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

    @Override
    public void updateCategory(Long categoryId,CategoryEntity category) {
        CategoryEntity existingCategory =categoryRepository.getById(categoryId);
        CategoryEntity updatedCategory=CategoryEntity.builder()
                .id(existingCategory.getId())
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .imageUrl(category.getImageUrl())
                .build();

        categoryRepository.save(updatedCategory);
    }

    @Override
    public boolean findById(Long categoryId) {
        return categoryRepository.findById(categoryId).isPresent();
    }
}
