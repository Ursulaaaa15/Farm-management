package com.example.service.controller;

import com.example.service.model.HarvestNorm;
import com.example.service.model.Product;
import com.example.service.service.HarvestNormService;
import com.example.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/harvestNorms")
public class HarvestNormController {
    @Autowired
    private HarvestNormService harvestNormService;
    @Autowired
    private ProductService productService;

    @PostMapping("/set")
    public ResponseEntity<?> setHarvestNorm(@RequestParam Long productId, @RequestParam double quantity, @RequestParam String unitOfMeasurement) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        harvestNormService.setHarvestNorm(product, quantity, unitOfMeasurement);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<HarvestNorm> getHarvestNorm(@RequestParam Long productId) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        HarvestNorm norm = harvestNormService.getHarvestNorm(product);
        if (norm == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(norm);
    }
}
