package com.example.malladminsystem.controller;

import com.example.malladminsystem.model.*;
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
        var contract = contractService
            .getContractByStore(store.getIdStore());

        model.addAttribute("store", store);
        model.addAttribute("contract", contract);
        return "store";
    }

    @GetMapping("/new")
    public String addStoreForm(Model model) {
        var store = new Store();
        var freeStores = storeService.getEmptyStores();

        model.addAttribute("stores", freeStores);
        model.addAttribute("store", store);
        return "add_store_form";
    }

    @GetMapping("/edit/")
    public String editStoreForm(@RequestParam Long id, Model model) {
        var store = storeService.getStoreById(id);

        model.addAttribute("store", store);
        return "edit_store_form";
    }

    @PostMapping("/edit")
    public String editStore(@ModelAttribute("store") Store store) {
        storeService.editStore(store);
        var storeId = store.getIdStore();

        var url = String.format("redirect:/stores/?id=%s", storeId);
        return url;
    }

    @PostMapping
    public String addStore(@ModelAttribute("store") Store store) {
        storeService.addNewStore(store);
        var storeId = store.getIdStore();

        var url = String.format("redirect:/stores/?id=%s", storeId);
        return url;
    }

}
