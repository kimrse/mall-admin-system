package com.example.malladminsystem.controller;

import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    @GetMapping()
    public String getVacancies(Model model) {
        var vacancies = vacancyService.getAllVacancies();
        model.addAttribute("vacancies", vacancies);
        return "vacancies";
    }

    @GetMapping("/")
    public String getVacancy(@RequestParam Long id, Model model) {
        var vacancy = vacancyService.getVacancy(id);
        model.addAttribute("vacancy", vacancy);
        return "vacancy";
    }

}
