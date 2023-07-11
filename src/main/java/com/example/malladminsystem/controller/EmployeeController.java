package com.example.malladminsystem.controller;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    private final VacancyService vacancyService;

    @GetMapping()
    public String getEmployees(Model model) {
        var employees = employeeService.getAllVacancies();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/")
    public String getEmployee(@RequestParam Long id, Model model) {
        var employee = employeeService.getVacancy(id);
        model.addAttribute("employee", employee);
        return "employee";
    }

    @GetMapping("/new")
    public String addEmployeeForm(Model model) {
        var employee = new Employee();
        var vacancies = vacancyService.getAllVacancies();

        model.addAttribute("employee", employee);
        model.addAttribute("vacancies", vacancies);
        return "add_employee_form";
    }

    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addNewEmployee(employee);
        return "redirect:/api/v1/employees";
    }
}
