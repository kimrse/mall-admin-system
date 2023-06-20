package com.example.malladminsystem.model;

import java.time.*;

public class Storage {
    private Long idStorage;
    private Long idStore;
    private String productName;
    private String supplier;
    private String manufacturerCountry;
    private String amount;
    private Double costPerDay;
    private LocalDate arrivalDate;
    private LocalDate deliveryDate;
    private boolean isDelivered;

    public Long getIdStorage() {
        return idStorage;
    }
    public Long getIdStore() {
        return idStore;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getManufacturerCountry() {
        return manufacturerCountry;
    }
    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public Double getCostPerDay() {
        return costPerDay;
    }
    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public boolean isDelivered() {
        return isDelivered;
    }
    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

}
