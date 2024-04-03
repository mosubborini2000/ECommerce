package com.example.ECommerce.service;

import com.example.ECommerce.dto.ProductRequest;
import com.example.ECommerce.dto.ProductResponse;
import com.example.ECommerce.model.CategoryEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    ResponseEntity<List<ProductResponse>> getAllProducts();
}
