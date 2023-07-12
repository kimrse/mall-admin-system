package com.example.malladminsystem.service;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.example.malladminsystem.model.*;
import com.example.malladminsystem.repository.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;

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

    public Tenant getTenantById(long id) {
        var tenant = tenantRepository.findById(id);
        return tenant;
    }

    public void saveImage(Tenant tenant, MultipartFile file) throws IOException {
        var fileName = file.getOriginalFilename();
        var currentPath = Paths.get(".");
        var absolutePath = currentPath.toAbsolutePath();
        var finalPath = absolutePath + "/src/main/resources/static/pictures";

        var fileNameAndPath = Paths.get(finalPath, fileName);
        Files.write(fileNameAndPath, file.getBytes());

        tenant.setPhoto(String.valueOf(fileNameAndPath));
        tenantRepository.save(tenant);
    }

    public void updateStatus(long id) {
        var tenant = tenantRepository.findById(id);
        var status = tenant.isDebtor();

        tenant.setDebtor(!status);
        tenantRepository.save(tenant);
    }

}
