package com.example.ECommerce.Mapper;
import com.example.ECommerce.dto.CategoryResponse;
import com.example.ECommerce.model.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryResponseMapper {
    CategoryResponse categoryEntityToCategoryResponse(CategoryEntity categoryEntity);

    List<CategoryResponse> categoryEntitiesToCategoryResponses(List<CategoryEntity> categoryEntities);
}
