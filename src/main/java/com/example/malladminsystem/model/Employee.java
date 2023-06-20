package com.example.malladminsystem.model;

import java.time.*;

public class Employee {
    private Long idEmployee;
    private Long idStore;
    private String firstName;
    private String lastName;
    private String middleName;
    private String jobTitle;
    private LocalDate hireDate;
    private Double monthlySalary;
    private String phone;
    public Long getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }
    public Long getIdStore() {
        return idStore;
    }
    public void setIdStore(Long idStore) {
        this.idStore = idStore;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    public Double getMonthlySalary() {
        return monthlySalary;
    }
    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
