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
        var details = promoResults.getResultsDetails();
        var cover = promoResults.getResultsCoverage();

        promo.setResultsDetails(details);
        promo.setResultsCoverage(cover);
        promo.setActive(false);
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

    public void updateActiveStatus(long id) {
        var promo = promoRepository.findById(id);
        var status = promo.isActive();

        promo.setActive(!status);
        promoRepository.save(promo);
    }

    public void editPromo(long promoId, Promo promoUpdate) {
        var promo = getPromoById(promoId);

        if (promoUpdate.getPromoType() != null) {
            promo.setPromoType(promoUpdate.getPromoType());
        }
        if (promoUpdate.getBudget() != null) {
            promo.setBudget(promoUpdate.getBudget());
        }
        if (promoUpdate.getStartDate() != null) {
            promo.setStartDate(promoUpdate.getStartDate());
        }
        if (promoUpdate.getEndDate() != null) {
            promo.setEndDate(promoUpdate.getEndDate());
        }
        if (promoUpdate.getPromoDescription() != null) {
            promo.setPromoDescription(promoUpdate.getPromoDescription());
        }

        promoRepository.save(promo);
    }
}
