package com.springboot.curd.services;

import com.springboot.curd.entities.PackageModel;

import java.util.List;
import java.util.UUID;


public interface PackageService {
    PackageModel createPackage(PackageModel tourPackage);
    PackageModel updatePackage(PackageModel tourPackage);
    void deletePackage(UUID id);
    PackageModel getPackageById(UUID id);
    List<PackageModel> getAllPackages();
}
