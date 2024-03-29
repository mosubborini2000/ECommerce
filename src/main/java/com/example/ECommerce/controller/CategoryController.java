package com.example.ECommerce.controller;//package com.example.ECommerce.controller;



import com.example.ECommerce.common.ApiResponse;
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
    public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryEntity category){
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true,"new category created"), HttpStatus.CREATED);

    }
    @GetMapping("/allCategory")
    public List<CategoryEntity> getAllCategories(){
        return categoryService.getAllCaegory();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long categoryId,@RequestBody CategoryEntity category){
        if(!categoryService.findById(categoryId)){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.NOT_FOUND);
        }
        categoryService.updateCategory(categoryId,category);
        return new ResponseEntity<>(new ApiResponse(true,"category updated"), HttpStatus.OK);

    }


}
