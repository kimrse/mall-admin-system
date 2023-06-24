package com.example.malladminsystem.repository;

import java.util.*;

import com.example.malladminsystem.model.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {

    Vacancy findById(long id);

    List<Vacancy> findAll();
}
