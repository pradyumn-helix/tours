package com.springboot.curd.controller;

import com.springboot.curd.entities.Cards;
import com.springboot.curd.services.CardsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class CardsController {
    @Autowired
    private CardsService cardsService;

    @GetMapping("/cards")
    public ResponseEntity<List<Cards>> getCards() {
        try {
            return new ResponseEntity<>(cardsService.getAllCards(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<Cards> getCard(@PathVariable UUID id) {
        try {
            System.out.println("ID"+id);
            Cards card = cardsService.getCardById(id);
            System.out.println("QUERY"+cardsService.getCardById(id));
            return new ResponseEntity<>(card, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cards")
    public ResponseEntity<Cards> addCard(@RequestBody Cards card) {
        try {
            return new ResponseEntity<>(cardsService.createCard(card), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/cards")
    public ResponseEntity<Cards> updateCard(@RequestBody Cards card){
        try {
            if(cardsService.getCardById(card.getId()).getId() != null) {
                return new ResponseEntity<>(cardsService.createCard(card), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
