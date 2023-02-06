package com.springboot.curd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.curd.entities.Booking;

import java.util.UUID;

public interface BookingDao extends JpaRepository<Booking, UUID> {

}
