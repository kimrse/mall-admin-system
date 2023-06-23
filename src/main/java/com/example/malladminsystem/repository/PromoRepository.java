package com.example.malladminsystem.repository;

import java.util.*;

import com.example.malladminsystem.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends CrudRepository<Promo, Long> {

//    @Query("select t from promo t join t.stores u")
    List<Promo> findAll();
//    List<Promo> findAllByLinkedStores;
    Promo findById(long id);

}
