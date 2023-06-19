package com.example.malladminsystem.repository;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Long, Long> {

}
