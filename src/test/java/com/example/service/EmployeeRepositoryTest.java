package com.example.service;

import com.example.service.model.Employee;
import com.example.service.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest { //тестовые контейнеры

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAllByActiveTrue() {
        Employee activeEmployee = new Employee();
        activeEmployee.setFullName("Петров Петр Сергеевич");
        activeEmployee.setEmail("active@example.com");
        activeEmployee.setActive(true);
        employeeRepository.save(activeEmployee);

        Employee inactiveEmployee = new Employee();
        inactiveEmployee.setFullName("Иванов Иван Иваныч");
        inactiveEmployee.setEmail("inactive@example.com");
        inactiveEmployee.setActive(false);
        employeeRepository.save(inactiveEmployee);

        List<Employee> activeEmployees = employeeRepository.findAllByActiveTrue();
        assertThat(activeEmployees).hasSize(1);
        assertThat(activeEmployees.get(0).getFullName()).isEqualTo("Петров Петр Сергеевич");
    }
}
