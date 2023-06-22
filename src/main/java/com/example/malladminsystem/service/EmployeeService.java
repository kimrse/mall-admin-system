package com.example.malladminsystem.service;

import java.time.*;
import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllVacancies() {
        var employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getVacancy(long id) {
        var employee = employeeRepository.findById(id);
        return employee;
    }

    public void addNewEmployee(Employee employee) {
        var curDate = LocalDate.now();
        var jobTitle = employee.getVacancy().getVacancyTitle();
        var store = employee.getVacancy().getStore();

        employee.setStore(store);
        employee.setHireDate(curDate);
        employee.setJobTitle(jobTitle);
        employee.setMonthlySalary(employee.getVacancy().getSalary());
        employeeRepository.save(employee);
    }

}
