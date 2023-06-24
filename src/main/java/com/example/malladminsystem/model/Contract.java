package com.example.malladminsystem.model;

import java.time.*;

import com.example.malladminsystem.dto.*;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "contract")
public class Contract implements ReportInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tenant")
    private Tenant tenant;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_store")
    private Store store;
    private String details;
    private LocalDate signedDate;
    private LocalDate endDate;
    private boolean isActive;
    private boolean isOverdue;

    public Long getIdContract() {
        return idContract;
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

    @Override
    public Object createReport() {
        var report = new ContractCreationReport(
            tenant.getFirstName(), tenant.getLastName(),
            tenant.getMiddleName(), tenant.getPhone(),
            store.getStoreTitle(), store.getStoreType(),
            store.getSquareArea(), store.getFloor(),
            store.getMonthlyCost(), this.getDetails(),
            this.getSignedDate(), this.getEndDate(),
            this.isOverdue()
        );
        return report;
    }

}
