package com.example.malladminsystem.service;

import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class ContractService implements ReportInterface {

    private final ContractRepository contractRepository;

    public List<Contract> getAllContracts() {
        var contracts = contractRepository.findAll();
        return contracts;
    }

    @Override
    public Object createReport(Object model) {
        return null;
    }

}
