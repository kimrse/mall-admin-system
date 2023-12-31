package com.example.malladminsystem.controller;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    private final StoreService storeService;

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

    @GetMapping("/new")
    public String addVacancyForm(Model model) {
        var vacancy = new Vacancy();
        var stores = storeService.getAllOccupiedStores();

        model.addAttribute("vacancy", vacancy);
        model.addAttribute("stores", stores);
        return "add_vacancy_form";
    }

    @PostMapping
    public String addVacancy(@ModelAttribute("vacancy") Vacancy vacancy) {
        vacancyService.addNewVacancy(vacancy);
        return "redirect:/api/v1/vacancies";
    }

    @GetMapping("/update")
    public String updateStatus(@RequestParam Long id) {
        vacancyService.updateStatus(id);

        var url = String.format("redirect:/api/v1/vacancies/?id=%s", id);
        return url;
    }

    @GetMapping("/edit/")
    public String editVacancyForm(@RequestParam Long id, Model model) {
        var vacancy = vacancyService.getVacancy(id);

        model.addAttribute("vacancy", vacancy);
        return "edit_vacancy_form";
    }

    @PostMapping("/edit/{id}")
    public String editVacancy(@PathVariable Long id, @ModelAttribute("vacancy") Vacancy vacancyUpdate) {
        vacancyService.editVacancy(id, vacancyUpdate);

        var url = String.format("redirect:/api/v1/vacancies/?id=%s", id);
        return url;
    }

}
