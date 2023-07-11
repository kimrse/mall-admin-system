package com.example.malladminsystem.controller;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/storage")
public class StorageController {

    private final StorageService storageService;

    private final StoreService storeService;

    @GetMapping()
    public String getStorage(Model model) {
        var storage = storageService.getAllStorage();
        model.addAttribute("storage", storage);
        return "storage_list";
    }

    @GetMapping("/")
    public String getStorageById(Model model, @RequestParam Long id) {
        var storage = storageService.getStorage(id);
//        var keepDays = storageService.countKeepDays(storage);
//        var totalCost = storageService.countKeepCost(storage);

        model.addAttribute("storage", storage);
        return "storage";
    }

    @GetMapping("/new")
    public String addStorageForm(Model model) {
        var storage = new Storage();
        var stores = storeService.getAllOccupiedStores();

        model.addAttribute("storage", storage);
        model.addAttribute("stores", stores);
        return "add_storage_form";
    }

    @PostMapping
    public String addStorage(@ModelAttribute("storage") Storage storage) {
        storageService.addNewPosition(storage);
        return "redirect:/api/v1/storage";
    }

    @GetMapping("/update")
    public String deliverStorage(@RequestParam Long id) {
        storageService.deliverStorage(id);

        var url = String.format("redirect:/api/v1/storage/?id=%s", id);
        return url;
    }

}
