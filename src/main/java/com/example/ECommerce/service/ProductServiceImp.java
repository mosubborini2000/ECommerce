package com.example.ECommerce.service;

import com.example.ECommerce.Repository.CategoryRepository;
import com.example.ECommerce.Repository.ProductRepository;
import com.example.ECommerce.dto.ProductRequest;
import com.example.ECommerce.model.CategoryEntity;
import com.example.ECommerce.model.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createProduct(ProductRequest productRequest) {
        Optional<CategoryEntity> optionalCategory=categoryRepository.findById(productRequest.getCategoryId());
        if(!optionalCategory.isPresent()){ throw new IllegalArgumentException("Category not found");}
        CategoryEntity category = optionalCategory.get();
        ProductEntity product=ProductEntity.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .imageUrl(productRequest.getImageUrl())
                .price(productRequest.getPrice())
                .category(category)
                .build();
        productRepository.save(product);


    }
}
