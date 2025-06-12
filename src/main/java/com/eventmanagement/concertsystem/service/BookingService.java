package com.eventmanagement.concertsystem.service;

import com.eventmanagement.concertsystem.model.Booking;
import com.eventmanagement.concertsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setUserId(updatedBooking.getUserId());
            booking.setTicketId(updatedBooking.getTicketId());
            booking.setBookingDate(updatedBooking.getBookingDate());
            booking.setPaymentStatus(updatedBooking.getPaymentStatus());
            booking.setBookingStatus(updatedBooking.getBookingStatus());
            return bookingRepository.save(booking);
        }).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
