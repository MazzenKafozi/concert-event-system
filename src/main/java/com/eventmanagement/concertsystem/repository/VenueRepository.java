package com.eventmanagement.concertsystem.repository;

import com.eventmanagement.concertsystem.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
