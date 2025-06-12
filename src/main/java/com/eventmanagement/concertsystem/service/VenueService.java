package com.eventmanagement.concertsystem.service;

import com.eventmanagement.concertsystem.model.Venue;
import com.eventmanagement.concertsystem.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }
    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }
}
