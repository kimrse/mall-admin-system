package com.example.malladminsystem.repository;

import com.example.malladminsystem.model.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

}
