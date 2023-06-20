package com.example.malladminsystem.model;

import java.time.*;

public class Invoice {
    private Long idInvoice;
    private Long idContract;
    private Double fee;
    private Long tax;
    private Double totalCost;
    private LocalDate dueDate;
    private LocalDate paidDate;
    private boolean isPaid;
    public Long getIdInvoice() {
        return idInvoice;
    }
    public Long getIdContract() {
        return idContract;
    }
    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }
    public Double getFee() {
        return fee;
    }
    public void setFee(Double fee) {
        this.fee = fee;
    }
    public Long getTax() {
        return tax;
    }
    public void setTax(Long tax) {
        this.tax = tax;
    }
    public Double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDate getPaidDate() {
        return paidDate;
    }
    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }
    public boolean isPaid() {
        return isPaid;
    }
    public void setPaid(boolean paid) {
        isPaid = paid;
    }

}
