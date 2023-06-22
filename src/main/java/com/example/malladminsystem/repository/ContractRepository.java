package com.example.malladminsystem.repository;

import java.util.*;

import com.example.malladminsystem.model.*;
import org.springframework.data.repository.*;

public interface ContractRepository extends CrudRepository<Contract, Long> {

    List<Contract> findAll();

    List<Contract> findAllByTenant(Tenant tenant);
    Contract findById(long id);
}
