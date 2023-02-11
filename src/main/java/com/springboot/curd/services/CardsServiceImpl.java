package com.springboot.curd.services;

import com.springboot.curd.dao.CardsDAO;
import com.springboot.curd.entities.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardsServiceImpl implements CardsService {

    private CardsDAO cardsDAO;

    @Autowired
    public CardsServiceImpl(CardsDAO cardsDAO) {
        this.cardsDAO = cardsDAO;
    }

    @Override
    public Cards createCard(Cards card) {
        return cardsDAO.save(card);
    }

    @Override
    public Cards getCardById(UUID id) {
        return cardsDAO.findById(id).orElse(null);
    }

    @Override
    public List<Cards> getAllCards() {
        return (List<Cards>) cardsDAO.findAll();
    }

    @Override
    public Cards updateCard(Cards card) {
        return cardsDAO.save(card);
    }

    @Override
    public void deleteCard(UUID id) {
        cardsDAO.deleteById(id);
    }
}
