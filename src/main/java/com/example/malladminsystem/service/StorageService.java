package com.example.malladminsystem.service;

import java.time.*;
import java.time.temporal.*;
import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepository storageRepository;

    public List<Storage> getAllStorage() {
        var storage = storageRepository.findAll();
        return storage;
    }

    public Storage getStorage(long id) {
        var storage = storageRepository.findById(id);
        return storage;
    }

    public void addNewPosition(Storage storage) {
        var curdate = LocalDate.now();
        storage.setArrivalDate(curdate);
        storageRepository.save(storage);
    }

    public Double countKeepCost(Storage storage) {
        var costPerDay = storage.getCostPerDay();
        var days = countKeepDays(storage);
        var total = costPerDay * days;
        return total;
    }

    public long countKeepDays(Storage storage) {
        var startDate = storage.getArrivalDate();
        var endDate = storage.getDeliveryDate();
        var diff = ChronoUnit.DAYS.between(startDate, endDate);
        return diff;
    }

    public void deliverStorage(Storage storage) {
        var curdate = LocalDate.now();
        storage.setDeliveryDate(curdate);
        storage.setDelivered(true);
        storageRepository.save(storage);
    }

}
