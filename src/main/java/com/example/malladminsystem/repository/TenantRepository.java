package com.example.malladminsystem.repository;

import java.util.*;

import com.example.malladminsystem.model.*;
import org.springframework.data.repository.*;

public interface TenantRepository extends CrudRepository<Tenant, Long> {

    List<Tenant> findAll();
}
