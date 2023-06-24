package com.example.malladminsystem.model;

import java.time.*;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "promo")
public class Promo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromo;

    @ManyToMany(mappedBy = "promos", fetch = FetchType.EAGER)
    private Set<Store> stores;

    private String promoType;

    private String promoDescription;

    private Double budget;

    private String resultsDetails;

    private Long resultsCoverage;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isActive;

    public Long getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(Long idPromo) {
        this.idPromo = idPromo;
    }

    public String getPromoType() {
        return promoType;
    }

    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getResultsDetails() {
        return resultsDetails;
    }

    public void setResultsDetails(String resultsDetails) {
        this.resultsDetails = resultsDetails;
    }

    public Long getResultsCoverage() {
        return resultsCoverage;
    }

    public void setResultsCoverage(Long resultsCoverage) {
        this.resultsCoverage = resultsCoverage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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

}
