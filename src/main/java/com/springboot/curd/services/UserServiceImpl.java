package com.springboot.curd.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.springboot.curd.dao.UserDao;
import com.springboot.curd.entities.User;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userDao.findById(id);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public void deleteById(UUID id) {
        userDao.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userDao.existsByEmail(email);
    }

    @Override
    public User verifyUserData(String email, String password){
        User user = userDao.findByEmail(email);
        if(matchPassword(password, user.getPassword())){
            return user;
        }
        throw new RuntimeException("No Data Found");
    }
    public boolean matchPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
