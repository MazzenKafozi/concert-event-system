package com.eventmanagement.concertsystem.service;

import com.eventmanagement.concertsystem.model.Ticket;
import com.eventmanagement.concertsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket existing = ticketRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setConcertId(updatedTicket.getConcertId());
            existing.setTicketType(updatedTicket.getTicketType());
            existing.setPrice(updatedTicket.getPrice());
            existing.setSeatNumber(updatedTicket.getSeatNumber());
            existing.setIsAvailable(updatedTicket.getIsAvailable());
            return ticketRepository.save(existing);
        }
        return null;
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
