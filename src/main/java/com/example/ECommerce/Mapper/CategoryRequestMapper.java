package com.example.ECommerce.Mapper;
import com.example.ECommerce.dto.CategoryRequest;
import com.example.ECommerce.model.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface CategoryRequestMapper {
    @Mappings({
            @Mapping(target = "id",ignore = true)
    })
    CategoryEntity categoryRequestToCategoryEntity(CategoryRequest categoryRequest);
    CategoryEntity updateCategoryEntityFromRequest(CategoryRequest categoryRequest, @MappingTarget CategoryEntity categoryEntity);

}
