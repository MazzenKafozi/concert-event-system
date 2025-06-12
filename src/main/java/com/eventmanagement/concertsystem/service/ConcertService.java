package com.eventmanagement.concertsystem.service;

import com.eventmanagement.concertsystem.model.Concert;
import com.eventmanagement.concertsystem.repository.ConcertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcertService {

    private final ConcertRepository concertRepository;

    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    // GET all concerts
    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }

    // GET by ID
    public Optional<Concert> getConcertById(Long id) {
        return concertRepository.findById(id);
    }

    // CREATE new concert
    public Concert createConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    // UPDATE concert
    public Concert updateConcert(Long id, Concert updatedConcert) {
        return concertRepository.findById(id)
                .map(concert -> {
                    concert.setTitle(updatedConcert.getTitle());
                    concert.setGenre(updatedConcert.getGenre());
                    concert.setDescription(updatedConcert.getDescription());
                    concert.setDate(updatedConcert.getDate());        // requires getDate() in Concert.java
                    concert.setTime(updatedConcert.getTime());        // requires getTime() in Concert.java
                    concert.setVenueId(updatedConcert.getVenueId());
                    concert.setCreatedBy(updatedConcert.getCreatedBy());
                    concert.setStatus(updatedConcert.getStatus());
                    return concertRepository.save(concert);
                })
                .orElse(null);
    }

    // DELETE concert
    public void deleteConcert(Long id) {
        concertRepository.deleteById(id);
    }
}
