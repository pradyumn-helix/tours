package com.springboot.curd.services;

import java.util.List;
import java.util.UUID;

import com.springboot.curd.entities.Booking;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(UUID id);
    List<Booking> getAllBookings();
    Booking updateBooking(Booking booking);
    void deleteBooking(UUID id);
}
