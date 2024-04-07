package com.example.ECommerce.service;

import com.example.ECommerce.Mapper.CategoryRequestMapper;
import com.example.ECommerce.Mapper.CategoryResponseMapper;
import com.example.ECommerce.Repository.CategoryRepository;
import com.example.ECommerce.dto.CategoryRequest;
import com.example.ECommerce.dto.CategoryResponse;
import com.example.ECommerce.model.CategoryEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
   private final CategoryRepository categoryRepository;
   private final CategoryRequestMapper categoryRequestMapper;
   private final CategoryResponseMapper categoryResponseMapper;

    public CategoryServiceImp(CategoryRepository categoryRepository, CategoryRequestMapper categoryRequestMapper, CategoryResponseMapper categoryResponseMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryRequestMapper = categoryRequestMapper;
        this.categoryResponseMapper = categoryResponseMapper;
    }

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity=categoryRequestMapper.categoryRequestToCategoryEntity(categoryRequest);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public ResponseEntity<List<CategoryResponse>> getAllCaegory() {
        List <CategoryEntity>categoryEntities=categoryRepository.findAll();
        List <CategoryResponse>categoryResponses=categoryResponseMapper.categoryEntitiesToCategoryResponses(categoryEntities);
        return ResponseEntity.ok(categoryResponses);

    }

    @Override
    public void updateCategory(Long categoryId,CategoryRequest category) {
        CategoryEntity existingCategory =categoryRepository.getById(categoryId);
//        CategoryEntity updatedCategory=CategoryEntity.builder()
//                .id(existingCategory.getId())
//                .categoryName(category.getCategoryName())
//                .description(category.getDescription())
//                .imageUrl(category.getImageUrl())
//                .build();
        CategoryEntity updatedCategory=categoryRequestMapper.updateCategoryEntityFromRequest(category,existingCategory);

        categoryRepository.save(updatedCategory);
    }

    @Override
    public boolean findById(Long categoryId) {
        return categoryRepository.findById(categoryId).isPresent();
    }
}
