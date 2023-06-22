package com.example.malladminsystem.dto;

import java.time.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class PromoReport {

    private String storeTitle;
    private Long floor;
    private String promoType;
    private String promoDescription;
    private Double budget;
    private String resultsDescription;
    private Long resultsCoverage;
    private LocalDate startDate;
    private LocalDate endDate;
}
