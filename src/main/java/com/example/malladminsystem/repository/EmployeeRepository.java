package com.example.malladminsystem.repository;

import java.util.*;

import com.example.malladminsystem.model.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findById(long id);

    List<Employee> findAll();
}
