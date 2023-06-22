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

}