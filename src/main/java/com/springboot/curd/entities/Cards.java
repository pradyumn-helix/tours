package com.springboot.curd.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Cards")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "cardholder_name", nullable = false)
    private String cardholderName;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @Column(name = "billing_address", nullable = false)
    private String billingAddress;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Cards() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cards(String cardNumber, String cardholderName, LocalDate expiryDate, String cvv, String billingAddress, User user) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
        this.user = user;
    }
}
