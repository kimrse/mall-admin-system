package com.example.malladminsystem.service;

import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public void addNewTenant(Tenant tenant) {
        tenantRepository.save(tenant);
    }

    public List<Tenant> getAllTenants() {
        var tenants = tenantRepository.findAll();
        return tenants;
    }
}
