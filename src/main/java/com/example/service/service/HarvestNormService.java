package com.example.service.service;

import com.example.service.model.HarvestNorm;
import com.example.service.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HarvestNormService {
    private Map<Product, HarvestNorm> norms = new HashMap<>();

    public void setHarvestNorm(Product product, double quantity, String unitOfMeasurement) {
        HarvestNorm norm = new HarvestNorm();
        norm.setProduct(product);
        norm.setQuantity(quantity);
        norm.setUnitOfMeasurement(unitOfMeasurement);
        norms.put(product, norm);
    }
    public HarvestNorm getHarvestNorm(Product product) {
        return norms.get(product);
    }
}
