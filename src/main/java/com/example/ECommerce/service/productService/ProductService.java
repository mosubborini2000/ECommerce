package com.example.ECommerce.service.productService;

import com.example.ECommerce.dto.productDto.ProductRequest;
import com.example.ECommerce.dto.productDto.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    ResponseEntity<List<ProductResponse>> getAllProducts();

    boolean findById(Long productId);

    void updateProduct(Long productId, ProductRequest productRequest);
}
