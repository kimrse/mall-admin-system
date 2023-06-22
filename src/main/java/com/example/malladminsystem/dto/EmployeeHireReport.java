package com.example.malladminsystem.dto;

import java.time.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeHireReport {

    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String storeTitle;
    private String vacancyTitle;
    private String vacancyDescription;
    private Double salary;
    private LocalDate hireDate;
}
