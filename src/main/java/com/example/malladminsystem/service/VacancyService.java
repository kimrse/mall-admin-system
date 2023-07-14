package com.example.malladminsystem.service;

import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public List<Vacancy> getAllVacancies() {
        var vacancies = vacancyRepository.findAll();
        return vacancies;
    }

    public Vacancy getVacancy(long id) {
        var vacancy = vacancyRepository.findById(id);
        return vacancy;
    }

    public void addNewVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public void updateStatus(long id) {
        var vacancy = vacancyRepository.findById(id);
        var status = vacancy.isActive();

        vacancy.setActive(!status);
        vacancyRepository.save(vacancy);
    }

    public void editVacancy(long vacancyId, Vacancy vacancyUpdate) {
        var vacancy = getVacancy(vacancyId);

        if (vacancyUpdate.getVacancyTitle() != null) {
            vacancy.setVacancyTitle(vacancyUpdate.getVacancyTitle());
        }
        if (vacancyUpdate.getSalary() != null) {
            vacancy.setSalary(vacancyUpdate.getSalary());
        }
        if (vacancyUpdate.getVacancyDescription() != null) {
            vacancy.setVacancyDescription(vacancyUpdate.getVacancyDescription());
        }

        vacancyRepository.save(vacancy);
    }

}
