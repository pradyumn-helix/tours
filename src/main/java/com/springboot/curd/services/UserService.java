package com.springboot.curd.services;

import com.springboot.curd.controller.UserController;
import com.springboot.curd.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(UUID id);
    User save(User user);
    void deleteById(UUID id);
    boolean existsByEmail(String email);
    User verifyUserData(String email, String password);
}
