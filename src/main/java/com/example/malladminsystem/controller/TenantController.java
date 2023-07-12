package com.example.malladminsystem.controller;

import java.io.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/tenants")
public class TenantController {

    private final TenantService tenantService;

    private final ContractService contractService;

    @GetMapping()
    public String getTenants(Model model) {
        var tenants = tenantService.getAllTenants();
        model.addAttribute("tenants", tenants);
        return "tenants";
    }

    @GetMapping("/")
    public String getTenant(@RequestParam Long id, Model model) {
        var tenant = tenantService.getTenantById(id);
        var contracts = contractService.getAllTenantContracts(tenant);

        model.addAttribute("tenant", tenant);
        model.addAttribute("contracts", contracts);
        return "tenant";
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
        return "redirect:/api/v1/tenants";
    }

    @GetMapping("/update/status/{id}")
    public String updateStatus(@PathVariable Long id) {
        tenantService.updateStatus(id);

        var url = String.format("redirect:/api/v1/tenants/?id=%s", id);
        return url;
    }

//    @GetMapping("/upload/")
//    public String imageUploadForm(@RequestParam Long id, Model model) {
//        var tenant = tenantService.getTenantById(id);
//        model.addAttribute("tenant", tenant);
//        return "upload_tenant_photo";
//    }

//    @PostMapping("/upload")
//    public String uploadImage(
//        @ModelAttribute("tenant") Tenant tenant, @RequestParam("image") MultipartFile file
//    ) throws IOException {
//        tenantService.saveImage(tenant, file);
//
//        var url = String.format("redirect:/tenant/?id=%s", tenant.getIdTenant());
//        return url;
//    }

}