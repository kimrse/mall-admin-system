package com.example.malladminsystem.service;

import java.time.*;
import java.time.temporal.*;
import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public void addNewInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        var invoices = invoiceRepository.findAll();
        return invoices;
    }

    public List<Invoice> getAllInvoicesByContractId(long id) {
        var invoices = invoiceRepository.findAllByContractIdContract(id);
        return invoices;
    }

    public Invoice getInvoice(long id) {
        var invoice = invoiceRepository.findByIdInvoice(id);
        return invoice;
    }

    public void setPaidStatus(Long id) {
        var invoice = invoiceRepository.findByIdInvoice(id);
        var status = invoice.isPaid();

        invoice.setPaid(!status);
        invoiceRepository.save(invoice);
    }

    public void updateTotalCost(Invoice invoice, Double storageCost) {
        var rent = countTotalRentCost(invoice);
        var totalCost = Double.sum(rent, storageCost);

        invoice.setTotalCost(totalCost);
        invoiceRepository.save(invoice);
    }

    public Double countTotalRentCost(Invoice invoice) {
        var tax = invoice.getTax();
        var fee = invoice.getFee();
        var monthsToPay = countMonths(invoice);
        var costPerMonth = invoice.getContract()
            .getStore()
            .getMonthlyCost();

        var totalCost = costPerMonth * monthsToPay;
        if (tax != 0) {
            totalCost = totalCost * ((100 + Math.abs(tax)) / 100D);
        }
        if (fee != null) {
            totalCost = totalCost + fee;
        }
        return (double) Math.round(totalCost);
    }

    public long countMonths(Invoice invoice) {
        var startDate = LocalDate.now();
        var endDate = invoice.getDueDate();

        var diff = ChronoUnit.MONTHS.between(startDate, endDate);
        return diff;
    }

}
