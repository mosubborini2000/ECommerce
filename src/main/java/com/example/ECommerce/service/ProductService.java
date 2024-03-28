package com.example.ECommerce.service;

import com.example.ECommerce.dto.ProductRequest;
import com.example.ECommerce.model.CategoryEntity;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
}
