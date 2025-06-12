package com.eventmanagement.concertsystem.repository;

import com.eventmanagement.concertsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
