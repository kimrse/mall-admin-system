package com.example.malladminsystem.dto;

import java.time.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class ContractCreationReport {

    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String storeTitle;
    private String storeType;
    private Long squareArea;
    private Long floor;
    private Double monthlyCost;
    private String details;
    private LocalDate signedDate;
    private LocalDate endDate;
    private boolean isOverdue;
}
