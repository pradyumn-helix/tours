package com.springboot.curd.controller;

import java.util.List;
import java.util.UUID;

import com.springboot.curd.entities.PackageModel;
import com.springboot.curd.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PackageController {
    @Autowired
    private PackageService packageService;

    @PostMapping("/packages")
    public ResponseEntity<PackageModel> createPackage(@RequestBody PackageModel tourPackage) {
        try {
            System.out.println(tourPackage);
            return new ResponseEntity<>(packageService.createPackage(tourPackage), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/packages")
    public ResponseEntity<PackageModel> updatePackage(@RequestBody PackageModel tourPackage) {
        try {
            return new ResponseEntity<>(packageService.updatePackage(tourPackage), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/packages/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable UUID id) {
        try {
            System.out.println(id);
            packageService.deletePackage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/packages/{id}")
    public ResponseEntity<PackageModel> getPackageById(@PathVariable UUID id) {
        try {
            PackageModel tourPackage = packageService.getPackageById(id);
            System.out.println(tourPackage);
            if (tourPackage != null) {
                return new ResponseEntity<>(tourPackage, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/packages")
    public ResponseEntity<List<PackageModel>> getAllPackages() {
        try {
            return new ResponseEntity<>(packageService.getAllPackages(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}