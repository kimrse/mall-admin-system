package com.example.malladminsystem.controller;

import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @GetMapping("/contracts")
    public String listContracts(Model model) {
        var contractsList = contractService.getAllContracts();
        model.addAttribute("contracts", contractsList);
        return "contracts";
    }
}
