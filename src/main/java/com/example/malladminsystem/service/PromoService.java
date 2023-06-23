package com.example.malladminsystem.service;

import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class PromoService {

    private final PromoRepository promoRepository;

    public void addNewPromo(Promo promo) {
        promoRepository.save(promo);
    }

    public List<Promo> getAllPromos() {
        var promos = promoRepository.findAll();
        return promos;
    }

    public Promo getPromoById(long id) {
        var promo = promoRepository.findById(id);
        return promo;
    }


}