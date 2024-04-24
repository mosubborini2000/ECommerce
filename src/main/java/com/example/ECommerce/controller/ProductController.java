package com.example.ECommerce.controller;

import com.example.ECommerce.common.ApiResponse;
import com.example.ECommerce.dto.productDto.ProductRequest;
import com.example.ECommerce.dto.productDto.ProductResponse;
import com.example.ECommerce.service.productService.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductRequest productRequest){
        try {
            productService.createProduct(productRequest);
            return new ResponseEntity<>(new ApiResponse(true,"product added "), HttpStatus.CREATED);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/allProduct")
    public ResponseEntity <List<ProductResponse>> getProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/updateProduct/{productId}")
    public ResponseEntity<ApiResponse> UpdateProduct(@PathVariable Long productId,@RequestBody ProductRequest productRequest){
        if(!productService.findById(productId)){
            return new ResponseEntity<>(new ApiResponse(false,"product doesnot exist"),HttpStatus.NOT_FOUND);
        }
        productService.updateProduct(productId,productRequest);
        return new ResponseEntity<>(new ApiResponse(true,"product updated"),HttpStatus.OK);
    }
}
