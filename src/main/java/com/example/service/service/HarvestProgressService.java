package com.example.service.service;

import com.example.service.model.Employee;
import com.example.service.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HarvestProgressService {
    private Map<Employee, Map<Product, Double>> harvestProgress = new HashMap<>();

    public void updateHarvestProgress(Employee employee, Product product, double quantity) {
        Map<Product, Double> employeeProgress = harvestProgress.getOrDefault(employee, new HashMap<>());
        double currentProgress = employeeProgress.getOrDefault(product, 0.0);
        employeeProgress.put(product, currentProgress + quantity);
        harvestProgress.put(employee, employeeProgress);
    }

    public double getHarvestProgress(Employee employee, Product product) {
        Map<Product, Double> employeeProgress = harvestProgress.getOrDefault(employee, new HashMap<>());
        return employeeProgress.getOrDefault(product, 0.0);
    }
}
