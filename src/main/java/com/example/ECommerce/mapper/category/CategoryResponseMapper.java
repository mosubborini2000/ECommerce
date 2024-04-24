package com.example.ECommerce.mapper.category;
import com.example.ECommerce.dto.categoryDto.CategoryResponse;
import com.example.ECommerce.model.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryResponseMapper {
    CategoryResponse categoryEntityToCategoryResponse(CategoryEntity categoryEntity);

    List<CategoryResponse> categoryEntitiesToCategoryResponses(List<CategoryEntity> categoryEntities);
}
