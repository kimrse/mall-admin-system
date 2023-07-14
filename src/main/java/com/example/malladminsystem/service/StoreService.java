package com.example.malladminsystem.service;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;

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

    public void clearStore(long id) {
        var store = getStoreById(id);

        store.setStoreTitle(null);
        store.setStoreDescription(null);
        store.setStoreType(null);
        store.setOccupied(false);
        storeRepository.save(store);
    }

//    public Set<Store> getPromoStores(Promo promo, long storeId) {
//        storeRepository.
//    }

    public void saveImage(Store store, MultipartFile file) throws IOException {
        var fileName = file.getOriginalFilename();
        var currentPath = Paths.get(".");
        var absolutePath = currentPath.toAbsolutePath();
        var finalPath = "." + "/src/main/resources/static/pictures";

        var fileNameAndPath = Paths.get(finalPath, fileName);
        Files.write(fileNameAndPath, file.getBytes());

        store.setPicture(String.valueOf(fileNameAndPath));
        storeRepository.save(store);
    }

}
