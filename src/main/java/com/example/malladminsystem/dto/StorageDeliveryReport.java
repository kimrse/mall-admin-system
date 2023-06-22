package com.example.malladminsystem.dto;

import java.time.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class StorageDeliveryReport {

    private String storeTitle;
    private Long idStorage;
    private String productName;
    private String supplier;
    private String manufacturerCountry;
    private String amount;
    private Double costPerDay;
    private LocalDate arrivalDate;
    private LocalDate deliveryDate;
}
