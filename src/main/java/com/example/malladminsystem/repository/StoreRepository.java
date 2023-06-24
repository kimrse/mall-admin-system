package com.example.malladminsystem.repository;

import java.util.*;

import com.example.malladminsystem.model.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

    List<Store> findAllByIsOccupiedIsFalse();

    List<Store> findAllByIsOccupiedIsTrue();

    List<Store> findAll();

//    List<Store> findAllByLinkedPromos(Set<Promo> promo);

    Store findById(long id);

}
