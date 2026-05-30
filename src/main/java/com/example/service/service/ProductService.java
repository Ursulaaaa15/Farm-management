package com.example.service.service;

import com.example.service.model.Product;
import com.example.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void registerProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}