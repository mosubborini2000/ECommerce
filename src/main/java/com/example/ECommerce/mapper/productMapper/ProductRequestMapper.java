package com.example.ECommerce.mapper.productMapper;
import com.example.ECommerce.dto.productDto.ProductRequest;
import com.example.ECommerce.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "category", ignore = true)
    })
    ProductEntity productRequestToProductEntity(ProductRequest productRequest);
    ProductEntity updateProductEntityFromRequest(ProductRequest productRequest,@MappingTarget ProductEntity productEntity);
}