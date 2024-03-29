package com.quickcart.productservice.service.implementation;

import com.quickcart.productservice.entity.ProductEntity;
import com.quickcart.productservice.repository.ProductRepository;
import com.quickcart.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return  productRepository.findById(id);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
