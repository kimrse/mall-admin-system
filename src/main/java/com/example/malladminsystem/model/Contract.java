package com.example.malladminsystem.model;

import java.time.*;

import jakarta.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;
    private Long idTenant;
    private Long idStore;
    private String details;
    private LocalDate signedDate;
    private LocalDate endDate;
    private boolean isActive;
    private boolean isOverdue;

    public Long getIdContract() {
        return idContract;
    }
    public Long getIdTenant() {
        return idTenant;
    }
    public Long getIdStore() {
        return idStore;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public LocalDate getSignedDate() {
        return signedDate;
    }
    public void setSignedDate(LocalDate signedDate) {
        this.signedDate = signedDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    public boolean isOverdue() {
        return isOverdue;
    }
    public void setOverdue(boolean overdue) {
        isOverdue = overdue;
    }

}
