package com.example.malladminsystem.controller;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

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
        model.addAttribute("employee", employee);
        return "add_employee_form";
    }

    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addNewEmployee(employee);
        return "redirect:/stores";
    }
}
