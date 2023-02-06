package com.springboot.curd.services;

import com.springboot.curd.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.curd.entities.Booking;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingDao.save(booking);
    }

    @Override
    public Booking getBookingById(UUID id) {
        return bookingDao.findById(id).orElse(null);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingDao.findAll();
    }

    @Override
    public Booking updateBooking(Booking booking) {
        Optional<Booking> optionalBooking = bookingDao.findById(booking.getId());
        Booking presentBooking = optionalBooking.get();
        presentBooking = booking;
        return bookingDao.save(presentBooking);
    }

    @Override
    public void deleteBooking(UUID id) {
        bookingDao.deleteById(id);
    }
}
