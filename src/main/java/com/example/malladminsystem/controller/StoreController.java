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
@RequestMapping("/api/v1/stores")
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

    @PostMapping("/edit/{id}")
    public String editStore(@PathVariable Long id, @ModelAttribute("store") Store storeUpdate) {
        storeService.editStore(id, storeUpdate);

        var url = String.format("redirect:/api/v1/stores/?id=%s", id);
        return url;
    }

    @PostMapping
    public String addStore(@ModelAttribute("store") Store store) {
        storeService.addNewStore(store);
        var storeId = store.getIdStore();

        var url = String.format("redirect:/api/v1/stores/?id=%s", storeId);
        return url;
    }

    @GetMapping("/clear/{id}")
    public String clearStore(@PathVariable Long id) {
        storeService.clearStore(id);

        var url = String.format("redirect:/api/v1/stores/?id=%s", id);
        return url;
    }

    @GetMapping("/upload/")
    public String imageUploadForm(@RequestParam Long id, Model model) {
        var store = storeService.getStoreById(id);

        model.addAttribute("store", store);
        return "upload_store_photo";
    }

    @PostMapping("/upload/{id}")
    public String uploadImage(
        @PathVariable Long id,
        @RequestParam("image") MultipartFile file
    ) throws IOException {
        var store = storeService.getStoreById(id);
        storeService.saveImage(store, file);

        var url = String.format("redirect:/api/v1/stores/?id=%s", store.getIdStore());
        return url;
    }

}
