package com.example.malladminsystem.controller;

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

    @GetMapping()
    public String getInvoices(Model model) {
        var invoices = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoices);
        return "invoices";
    }

    @GetMapping("/")
    public String getInvoice(Model model, @RequestParam Long id) {
        var invoice = invoiceService.getInvoice(id);
        model.addAttribute("invoice", invoice);
        return "invoice";
    }

    @GetMapping("paid")
    public String updatePaidStatus(@RequestParam Long id) {
        invoiceService.setPaidStatus(id);
        return "redirect:/invoices";
    }

}
