package com.example.malladminsystem.controller;

import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    private final ContractService contractService;

    @GetMapping()
    public String getAllStores(Model model) {
        var stores = storeService.getAllStores();
        model.addAttribute("stores", stores);
        return "stores";
    }
    @GetMapping("/")
    public String getStore(@RequestParam Long id, Model model) {
        var store = storeService.getStoreById(id);
        model.addAttribute("store", store);
        return "store";
    }

}
