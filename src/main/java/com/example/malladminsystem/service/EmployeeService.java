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

    public Employee getEmployee(long id) {
        var employee = employeeRepository.findById(id);
        return employee;
    }

    public void addNewEmployee(Employee employee) {
        var curDate = LocalDate.now();
        var jobTitle = employee.getVacancy().getVacancyTitle();

        employee.setHireDate(curDate);
        employee.setJobTitle(jobTitle);
        employee.setMonthlySalary(employee.getVacancy().getSalary());
        employeeRepository.save(employee);
    }

    public void editEmployee(long employeeId, Employee employeeUpdate) {
        var employee = getEmployee(employeeId);

        if (employeeUpdate.getFirstName() != null) {
            employee.setFirstName(employeeUpdate.getFirstName());
        }
        if (employeeUpdate.getLastName() != null) {
            employee.setLastName(employeeUpdate.getLastName());
        }
        if (employeeUpdate.getMiddleName() != null) {
            employee.setMiddleName(employeeUpdate.getMiddleName());
        }
        if (employeeUpdate.getPhone() != null) {
            employee.setPhone(employeeUpdate.getPhone());
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee(long id) {
        var employee = getEmployee(id);
        employeeRepository.delete(employee);
    }
}
