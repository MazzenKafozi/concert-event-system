package com.eventmanagement.concertsystem.controller;

import com.eventmanagement.concertsystem.model.Concert;
import com.eventmanagement.concertsystem.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eventmanagement.concertsystem.model.Venue;
import com.eventmanagement.concertsystem.repository.VenueRepository;


import java.util.List;

@RestController
@RequestMapping("/concerts")
public class ConcertController {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private ConcertRepository concertRepository;

    @GetMapping
    public List<Concert> getAllConcerts() {
        List<Concert> concerts = concertRepository.findAll();
        for (Concert concert : concerts) {
            Venue venue = venueRepository.findById(concert.getVenueId()).orElse(null);
            if (venue != null) {
                concert.setVenueName(venue.getName());
                concert.setVenueCity(venue.getCity());
            }
        }
        return concerts;
    }


    // GET concert by ID
    @GetMapping("/{id}")
    public ResponseEntity<Concert> getConcertById(@PathVariable Long id) {
        return concertRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST a new concert
    @PostMapping
    public Concert createConcert(@RequestBody Concert concert) {
        return concertRepository.save(concert);
    }

    // PUT (Update) a concert
    @PutMapping("/{id}")
    public ResponseEntity<Concert> updateConcert(@PathVariable Long id, @RequestBody Concert concertDetails) {
        return concertRepository.findById(id)
                .map(concert -> {
                    concert.setTitle(concertDetails.getTitle());
                    concert.setGenre(concertDetails.getGenre());
                    concert.setDescription(concertDetails.getDescription());
                    concert.setDate(concertDetails.getDate());
                    concert.setTime(concertDetails.getTime());
                    concert.setVenueId(concertDetails.getVenueId());
                    concert.setCreatedBy(concertDetails.getCreatedBy());
                    concert.setStatus(concertDetails.getStatus());

                    Venue venue = venueRepository.findById(concert.getVenueId()).orElse(null);
                    if (venue != null) {
                        concert.setVenueName(venue.getName());
                        concert.setVenueCity(venue.getCity());
                    }

                    Concert updatedConcert = concertRepository.save(concert);
                    return ResponseEntity.ok(updatedConcert);
                })

                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE a concert
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcert(@PathVariable Long id) {
        return concertRepository.findById(id)
                .map(concert -> {
                    concertRepository.delete(concert);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
