package com.example.malladminsystem.controller;

import java.util.stream.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    private final StorageService storageService;

    private final ContractService contractService;

    @GetMapping()
    public String getInvoices(Model model) {
        var invoices = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoices);
        return "invoices";
    }

    @GetMapping("/")
    public String getInvoice(Model model, @RequestParam Long id) {
        var invoice = invoiceService.getInvoice(id);
        var storeId = invoice.getContract()
            .getStore()
            .getIdStore();

        var storage = storageService.getAllStoreStorage(storeId);
        var totalStorageCost =  storage.stream()
            .collect(Collectors.summarizingDouble(storageService::countKeepCost))
            .getSum();

        model.addAttribute("storageCost", totalStorageCost);
        model.addAttribute("invoice", invoice);
        return "invoice";
    }

    @GetMapping("paid")
    public String updatePaidStatus(@RequestParam Long id) {
        invoiceService.setPaidStatus(id);
        return "redirect:/invoices";
    }

    @GetMapping("/new")
    public String addInvoiceForm(Model model) {
        var invoice = new Invoice();
        var contracts = contractService.getAllActiveContracts();

        model.addAttribute("invoice", invoice);
        model.addAttribute("contracts", contracts);
        return "add_invoice_form";
    }

    @PostMapping
    public String addInvoice(@ModelAttribute("invoice") Invoice invoice) {
        var storeId = invoice.getContract()
            .getStore()
            .getIdStore();

        var storage = storageService.getAllStoreStorage(storeId);
        var totalStorageCost =  storage.stream()
            .collect(Collectors.summarizingDouble(storageService::countKeepCost))
            .getSum();

        var totalRentCost = invoiceService.countTotalRentCost(invoice);
        var totalCost = Double.sum(totalRentCost, totalStorageCost);

        invoice.setTotalCost(totalCost);
        invoiceService.addNewInvoice(invoice);
        return "redirect:/invoices";
    }

}
