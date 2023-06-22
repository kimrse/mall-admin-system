package com.example.malladminsystem.service;

import java.time.*;
import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public List<Contract> getAllContracts() {
        var contracts = contractRepository.findAll();
        return contracts;
    }

    public Contract getContract(long id) {
        var contract = contractRepository.findById(id);
        return contract;
    }

    public void addNewContract(Contract contract) {
        var store = contract.getStore();
        var curDate = LocalDate.now();

        contract.setActive(true);
        store.setOccupied(true);
        contract.setSignedDate(curDate);
        contractRepository.save(contract);
    }

}
