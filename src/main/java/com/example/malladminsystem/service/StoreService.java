package com.example.malladminsystem.service;

import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public void addNewStore(Store store) {
        storeRepository.save(store);
    }

    public void editStore(long storeId, Store updateStore) {
        var store = storeRepository.findById(storeId);

        store.setStoreTitle(updateStore.getStoreTitle());
        store.setStoreType(updateStore.getStoreType());
        store.setStoreDescription(updateStore.getStoreDescription());

        storeRepository.save(store);
    }

    public List<Store> getEmptyStores() {
        var emptyStores = storeRepository.findAllByIsOccupiedIsFalse();
        return emptyStores;
    }

    public List<Store> getAllStores() {
        var stores = storeRepository.findAll();
        return stores;
    }

    public List<Store> getAllOccupiedStores() {
        var stores = storeRepository.findAllByIsOccupiedIsTrue();;
        return stores;
    }

    public Store getStoreById(long id) {
        var store = storeRepository.findById(id);
        return store;
    }

//    public Set<Store> getPromoStores(Promo promo, long storeId) {
//        storeRepository.
//    }

}
