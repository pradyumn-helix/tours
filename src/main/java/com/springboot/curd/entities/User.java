package com.springboot.curd.entities;

import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "contact")
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Booking> booking;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Cards> card;

    public enum Role {
        User,
        Admin
    }

    public User() {}

    public User(String name, String email, String password, String contact, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    public Set<Cards> getCard() {
        return card;
    }

    public void setCard(Set<Cards> card) {
        this.card = card;
    }
}
