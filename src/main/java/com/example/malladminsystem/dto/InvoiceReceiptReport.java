package com.example.malladminsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class InvoiceReceiptReport {

    private String firstName;
    private String lastName;
    private String middleName;
    private Long idContract;
    private String storeTitle;
    private Double fee;
    private Long tax;
    private Double monthlyCost;
    private Double totalCost;
    private boolean isPaid;
}
