package com.eventmanagement.concertsystem.repository;

import com.eventmanagement.concertsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
