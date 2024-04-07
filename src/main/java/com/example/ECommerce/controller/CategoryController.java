package com.example.ECommerce.controller;//package com.example.ECommerce.controller;



import com.example.ECommerce.common.ApiResponse;
import com.example.ECommerce.dto.CategoryRequest;
import com.example.ECommerce.dto.CategoryResponse;
import com.example.ECommerce.model.CategoryEntity;
import com.example.ECommerce.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(new ApiResponse(true,"new category created"), HttpStatus.CREATED);

    }
    @GetMapping("/allCategory")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        return categoryService.getAllCaegory();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long categoryId,@RequestBody CategoryRequest category){
        if(!categoryService.findById(categoryId)){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.NOT_FOUND);
        }
        categoryService.updateCategory(categoryId,category);
        return new ResponseEntity<>(new ApiResponse(true,"category updated"), HttpStatus.OK);

    }

}
