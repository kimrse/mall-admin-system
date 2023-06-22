package com.example.malladminsystem.controller;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tenants")
public class TenantController {

    private final TenantService tenantService;

    @GetMapping()
    public String getTenants(Model model) {
        var tenants = tenantService.getAllTenants();
        model.addAttribute("tenants", tenants);
        return "tenants";
    }

    @GetMapping("/new")
    public String addTenantForm(Model model) {
        var tenant = new Tenant();
        model.addAttribute("tenant", tenant);
        return "add_tenant_form";
    }

    @PostMapping
    public String addTenant(@ModelAttribute("tenant") Tenant tenant) {
        tenantService.addNewTenant(tenant);
        return "redirect:/tenants";
    }
}
