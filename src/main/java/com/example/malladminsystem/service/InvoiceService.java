package com.example.malladminsystem.service;

import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        var invoices = invoiceRepository.findAll();
        return invoices;
    }

    public Invoice getInvoice(long id) {
        var invoice = invoiceRepository.findByIdInvoice(id);
        return invoice;
    }

    public void setPaidStatus(Long id) {
        var invoice = invoiceRepository.findByIdInvoice(id);
        invoice.setPaid(true);
        invoiceRepository.save(invoice);
    }

}
