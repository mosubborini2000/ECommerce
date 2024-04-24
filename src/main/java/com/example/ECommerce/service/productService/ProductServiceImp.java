package com.example.ECommerce.service.productService;


import com.example.ECommerce.mapper.productMapper.ProductRequestMapper;
import com.example.ECommerce.mapper.productMapper.ProductResponseMapper;
import com.example.ECommerce.repository.CategoryRepository;
import com.example.ECommerce.repository.ProductRepository;
import com.example.ECommerce.dto.productDto.ProductRequest;
import com.example.ECommerce.dto.productDto.ProductResponse;
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
        ProductEntity productEntity=productMapper.productRequestToProductEntity(productRequest);
        productEntity.setCategory(category);

//                ProductEntity.builder()
//                .name(productRequest.getName())
//                .description(productRequest.getDescription())
//                .imageUrl(productRequest.getImageUrl())
//                .price(productRequest.getPrice())
//                .category(category)
//                .build();
        productRepository.save(productEntity);


    }
    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        List<ProductResponse> productResponses = productResponseMapper.productEntitiesToProductResponses(products);
        return ResponseEntity.ok(productResponses);
    }

    @Override
    public boolean findById(Long productId) {
       return productRepository.findById(productId).isPresent();
    }

    @Override
    public void updateProduct(Long productId, ProductRequest productRequest) {
        ProductEntity productEntity=productRepository.getById(productId);
        productMapper.updateProductEntityFromRequest(productRequest,productEntity);
        productRepository.save(productEntity);

    }
}
