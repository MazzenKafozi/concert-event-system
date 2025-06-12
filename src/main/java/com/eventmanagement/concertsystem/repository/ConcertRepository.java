package com.eventmanagement.concertsystem.repository;

import com.eventmanagement.concertsystem.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
