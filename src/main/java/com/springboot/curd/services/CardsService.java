package com.springboot.curd.services;

import com.springboot.curd.entities.Cards;

import java.util.List;
import java.util.UUID;

public interface CardsService {

    Cards createCard(Cards card);

    Cards getCardById(UUID id);

    List<Cards> getAllCards();

    Cards updateCard(Cards card);

    void deleteCard(UUID id);
}
