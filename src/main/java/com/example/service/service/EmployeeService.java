package com.example.service.service;

import com.example.service.model.Employee;
import com.example.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void blockEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setActive(false);
            employeeRepository.save(employee);
        }
    }

    public void unblockEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setActive(true);
            employeeRepository.save(employee);
        }
    }

    public void registerEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllActiveEmployees() {
        return employeeRepository.findAllByActiveTrue();
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }
}