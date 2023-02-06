package com.springboot.curd.entities;

import com.sun.istack.NotNull;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private PackageModel packageId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @NotNull
    @Column(name = "booking_date")
    private String bookingDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingStatus status;

    // getters and setters ...

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PackageModel getPackageId() {
        return packageId;
    }

    public void setPackageId(PackageModel packageId) {
        this.packageId = packageId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Booking() {
    }

    public Booking(PackageModel packageId, User userId, String bookingDate, BookingStatus status) {
        this.packageId = packageId;
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.status = status;
    }
}

enum BookingStatus {
    Confirm,
    Cancel
}
