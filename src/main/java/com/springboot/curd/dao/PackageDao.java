package com.springboot.curd.dao;

import com.springboot.curd.entities.PackageModel;
import com.springboot.curd.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PackageDao extends JpaRepository<PackageModel, UUID> {
    Optional<PackageModel> findById(UUID id);

    void deleteById(UUID id);

}
