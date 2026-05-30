package com.example.service.controller;

import com.example.service.model.Employee;
import com.example.service.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public void registerEmployee(@RequestBody Employee employee) {
        employeeService.registerEmployee(employee);
    }

    @GetMapping("/active")
    public List<Employee> getAllActiveEmployees() {
        return employeeService.getAllActiveEmployees();
    }

    @PutMapping("/block/{employeeId}")
    public void blockEmployee(@PathVariable Long employeeId) {
        employeeService.blockEmployee(employeeId);
    }

    @PutMapping("/unblock/{employeeId}")
    public void unblockEmployee(@PathVariable Long employeeId) {
        employeeService.unblockEmployee(employeeId);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }
}