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
//        var stores = promo.getStores();
//        Set<Long> storeIds = new HashSet<>() ;
//
//        stores.forEach(i->{
//            storeIds.add(i.getIdStore());
//        });
//        promo
//        promo.setStores(stores);

        promoRepository.save(promo);
    }

    public void saveResults(long id, Promo promoResults) {
        var promo = getPromoById(id);
        var desc = promoResults.getPromoDescription();
        var cover = promo.getResultsCoverage();

        promo.setPromoDescription(desc);
        promo.setResultsCoverage(cover);
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
