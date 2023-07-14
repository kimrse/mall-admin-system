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

    public List<Storage> getAllStoreStorage(long id) {
        var storage = storageRepository.findAllByStoreIdStore(id);
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
        var days = countKeepDays(storage) + 1L;
        var total = costPerDay * days;
        return total;
    }

    public long countKeepDays(Storage storage) {
        long diff;
        var startDate = storage.getArrivalDate();
        var endDate = storage.getDeliveryDate();

        diff = ChronoUnit.DAYS.between(
            startDate,
            Objects.requireNonNullElseGet(endDate, LocalDate::now));

        return diff;
    }

    public void deliverStorage(long id) {
        var storage = storageRepository.findById(id);
        var curdate = LocalDate.now();
        var status = storage.isDelivered();

        if (status) {
            storage.setDeliveryDate(null);
            storage.setDelivered(false);
        } else {
            storage.setDeliveryDate(curdate);
            storage.setDelivered(true);
        }
        storageRepository.save(storage);
    }

    public void editStorage(long id, Storage storageUpdate) {
        var storage = getStorage(id);

        if (storageUpdate.getProductName() != null) {
            storage.setProductName(storageUpdate.getProductName());
        }
        if (storageUpdate.getSupplier() != null) {
            storage.setSupplier(storageUpdate.getSupplier());
        }
        if (storageUpdate.getManufacturerCountry() != null) {
            storage.setManufacturerCountry(storageUpdate.getManufacturerCountry());
        }
        if (storageUpdate.getAmount() != null) {
            storage.setAmount(storageUpdate.getAmount());
        }
        if (storageUpdate.getCostPerDay() != null) {
            storage.setCostPerDay(storageUpdate.getCostPerDay());
        }

        storageRepository.save(storage);
    }
}
