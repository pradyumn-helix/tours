package com.springboot.curd.dao;

import com.springboot.curd.entities.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardsDAO extends JpaRepository<Cards, UUID> {
}
