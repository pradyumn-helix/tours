package com.springboot.curd.services;

import java.util.List;
import java.util.UUID;

import com.springboot.curd.dao.PackageDao;
import com.springboot.curd.entities.PackageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageDao packageDao;

    @Override
    public PackageModel createPackage(PackageModel tourPackage) {
        return packageDao.save(tourPackage);
    }

    @Override
    public PackageModel updatePackage(PackageModel tourPackage) {
        System.out.println("T"+ tourPackage);
        return packageDao.save(tourPackage);
    }

    @Override
    public void deletePackage(UUID id) {
        System.out.println(id);
        packageDao.deleteById(id);
    }

    @Override
    public PackageModel getPackageById(UUID id) {
        return packageDao.findById(id).orElse(null);
    }

    @Override
    public List<PackageModel> getAllPackages() {
        return packageDao.findAll();
    }

}
