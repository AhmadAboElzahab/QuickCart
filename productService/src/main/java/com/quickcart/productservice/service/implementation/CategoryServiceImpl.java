package com.quickcart.productservice.service.implementation;

import com.quickcart.productservice.entity.CategoryEntity;
import com.quickcart.productservice.repository.CategoryRepository;
import com.quickcart.productservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> findAllCategories() {
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching all categories", e);
        }
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        try {
            return categoryRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching category with ID: " + id, e);
        }
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        try {
            return categoryRepository.save(categoryEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while saving category", e);
        }
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
        try {
            if (categoryRepository.existsById(categoryEntity.getId())) {
                return categoryRepository.save(categoryEntity);
            } else {
                throw new IllegalArgumentException("Category with ID: " + categoryEntity.getId() + " does not exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while updating category", e);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting category with ID: " + id, e);
        }
    }
}
