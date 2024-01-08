package com.quickcart.productservice.controller;

import com.quickcart.productservice.entity.CategoryEntity;
import com.quickcart.productservice.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private  final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<CategoryEntity> findAllCategory(){
        return categoryService.findAllCategories();
    }
    @GetMapping("/{id}")
    public Optional<CategoryEntity> findCategoryById(@PathVariable("id") Long id){
    return categoryService.findById(id);
    }
    @PostMapping
    public CategoryEntity saveCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.saveCategory(categoryEntity);
    }

    @PutMapping
    public CategoryEntity updateCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.updateCategory(categoryEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }
}
