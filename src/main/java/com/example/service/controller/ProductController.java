package com.example.service.controller;

import com.example.service.model.Product;
import com.example.service.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/register")
    public void registerProduct(@RequestBody Product product) {
        productService.registerProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
}