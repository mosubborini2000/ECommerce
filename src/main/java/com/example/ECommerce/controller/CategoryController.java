package com.example.ECommerce.controller;//package com.example.ECommerce.controller;



import com.example.ECommerce.model.CategoryEntity;
import com.example.ECommerce.service.CategoryService;
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
    public String createCategory(@RequestBody CategoryEntity category){
        categoryService.createCategory(category);
        return "successfuly";

    }
    @GetMapping("/allCategory")
    public List<CategoryEntity> getAllCategories(){
        return categoryService.getAllCaegory();
    }


}
