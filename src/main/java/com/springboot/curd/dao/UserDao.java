package com.springboot.curd.dao;

import com.springboot.curd.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findById(UUID id);

    void deleteById(UUID id);

    boolean existsByEmail(String email);
}
