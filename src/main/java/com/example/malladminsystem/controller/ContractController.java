package com.example.malladminsystem.controller;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;
    private final StoreService storeService;
    private final TenantService tenantService;

    @GetMapping()
    public String getContracts(Model model) {
        var contractsList = contractService.getAllContracts();
        model.addAttribute("contracts", contractsList);
        return "contracts";
    }

    @GetMapping("/")
    public String getContractById(Model model, @RequestParam Long id) {
        var contract = contractService.getContract(id);
        model.addAttribute("contract", contract);
        return "contract";
    }

    @GetMapping("/store/")
    public String getContractByStoreId(Model model, @RequestParam Long id) {
        var contract = contractService.getContractByStore(id);
        model.addAttribute("contract", contract);
        return "contract";
    }

    @GetMapping("/new")
    public String addContractForm(Model model) {
        var contract = new Contract();
        var emptyStores = storeService.getEmptyStores();
        var tenants = tenantService.getAllTenants();

        model.addAttribute("contract", contract);
        model.addAttribute("emptyStores" , emptyStores);
        model.addAttribute("tenants", tenants);
        return "add_contract_form";
    }

    @PostMapping
    public String addContract(@ModelAttribute("contract") Contract contract) {
        contractService.addNewContract(contract);
        return "redirect:/contracts";
    }

}
