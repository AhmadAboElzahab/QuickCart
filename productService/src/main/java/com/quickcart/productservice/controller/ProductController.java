package com.quickcart.productservice.controller;

import com.quickcart.productservice.entity.CategoryEntity;
import com.quickcart.productservice.entity.ProductEntity;
import com.quickcart.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductEntity> findAllProduct() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Long id) {
        try {
            Optional<ProductEntity> product = productService.findById(id);
            return ResponseEntity.ok(product.orElse(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving product");
        }
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductEntity productEntity) {
        try {
            if (productEntity.getCategory() == null && productEntity.getCategoryId() != null) {
                CategoryEntity category = new CategoryEntity();
                category.setId(productEntity.getCategoryId());
                productEntity.setCategory(category);
            }

            ProductEntity savedProduct = productService.saveProduct(productEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving product");
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductEntity productEntity) {
        try {
            ProductEntity updatedProduct = productService.updateProduct(productEntity);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating product");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting product");
        }
    }
}
