package com.example.service.controller;

import com.example.service.model.Employee;
import com.example.service.model.Product;
import com.example.service.service.EmployeeService;
import com.example.service.service.HarvestProgressService;
import com.example.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/harvestProgress")
public class HarvestProgressController {
    @Autowired
    private HarvestProgressService harvestProgressService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProductService productService;

    @PostMapping("/update")
    public ResponseEntity<?> updateHarvestProgress(@RequestParam Long employeeId, @RequestParam Long productId, @RequestParam double quantity) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        harvestProgressService.updateHarvestProgress(employee, product, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<Double> getHarvestProgress(@RequestParam Long employeeId, @RequestParam Long productId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        double progress = harvestProgressService.getHarvestProgress(employee, product);
        return ResponseEntity.ok(progress);
    }
}
