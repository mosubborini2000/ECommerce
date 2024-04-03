package com.example.ECommerce.service;


import com.example.ECommerce.Mapper.ProductRequestMapper;
import com.example.ECommerce.Mapper.ProductResponseMapper;
import com.example.ECommerce.Repository.CategoryRepository;
import com.example.ECommerce.Repository.ProductRepository;
import com.example.ECommerce.dto.ProductRequest;
import com.example.ECommerce.dto.ProductResponse;
import com.example.ECommerce.model.CategoryEntity;
import com.example.ECommerce.model.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRequestMapper productMapper;
    private final ProductResponseMapper productResponseMapper;

    public ProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository, ProductRequestMapper productMapper, ProductResponseMapper productResponseMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public void createProduct(ProductRequest productRequest) {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(productRequest.getCategoryId());
        if (!optionalCategory.isPresent()) {
            throw new IllegalArgumentException("Category not found");
        }
        CategoryEntity category = optionalCategory.get();
        ProductEntity product=productMapper.productRequestToProductEntity(productRequest);
        product.setCategory(category);

//                ProductEntity.builder()
//                .name(productRequest.getName())
//                .description(productRequest.getDescription())
//                .imageUrl(productRequest.getImageUrl())
//                .price(productRequest.getPrice())
//                .category(category)
//                .build();
        productRepository.save(product);


    }
    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        List<ProductResponse> productResponses = productResponseMapper.productEntitiesToProductResponses(products);
        return ResponseEntity.ok(productResponses);
    }
}
