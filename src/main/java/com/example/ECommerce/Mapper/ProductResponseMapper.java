package com.example.ECommerce.Mapper;

import com.example.ECommerce.dto.ProductResponse;
import com.example.ECommerce.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {
    @Mappings({
            @Mapping(source = "category.id", target = "categoryId")
    })
    ProductResponse productEntityToProductResponse(ProductEntity productEntity);

    List<ProductResponse> productEntitiesToProductResponses(List<ProductEntity> productEntities);
}

