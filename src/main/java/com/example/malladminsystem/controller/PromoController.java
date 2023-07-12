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
@RequestMapping("/api/v1/promos")
public class PromoController {

    private final PromoService promoService;

    private final StoreService storeService;

    @GetMapping()
    public String getPromos(Model model) {
        var promos = promoService.getAllPromos();

        model.addAttribute("promos", promos);
        return "promos";
    }

    @GetMapping("/")
    public String getPromo(@RequestParam Long id, Model model) {
        var promo = promoService.getPromoById(id);

        model.addAttribute("promo", promo);
        return "promo";
    }

    @GetMapping("/new")
    public String addPromoForm(Model model) {
        var promo = new Promo();
        var stores = storeService.getAllOccupiedStores();

        model.addAttribute("promo", promo);
        model.addAttribute("stores", stores);
        return "add_promo_form";
    }

    @PostMapping
    public String addPromo(@ModelAttribute("tenant") Promo promo, Model model) {
        promoService.addNewPromo(promo);
        var promoId = promo.getIdPromo();

        var url = String.format("redirect:/api/v1/promos/?id=%s", promoId);
        return url;
    }

    @GetMapping("/results/")
    public String resultsPromoForm(@RequestParam Long id, Model model) {
        var promo = promoService.getPromoById(id);

        model.addAttribute("promo", promo);
        return "results_promo_form";
    }

    @PostMapping("/results/{id}")
    public String resultsPromo(@PathVariable Long id, @ModelAttribute("promo") Promo promo) {
        promoService.saveResults(id, promo);

        var url = String.format("redirect:/api/v1/promos/?id=%s", id);
        return url;
    }

    @GetMapping("/update/active/{id}")
    public String updateActiveStatus(@PathVariable Long id) {
        promoService.updateActiveStatus(id);

        var url = String.format("redirect:/api/v1/promos/?id=%s", id);
        return url;
    }

}
