package com.eventmanagement.concertsystem.config;

import com.eventmanagement.concertsystem.model.Concert;
import com.eventmanagement.concertsystem.model.TicketType;
import com.eventmanagement.concertsystem.model.Venue;
import com.eventmanagement.concertsystem.repository.ConcertRepository;
import com.eventmanagement.concertsystem.repository.VenueRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder {

    private final VenueRepository venueRepository;
    private final ConcertRepository concertRepository;

    public DataSeeder(VenueRepository venueRepository, ConcertRepository concertRepository) {
        this.venueRepository = venueRepository;
        this.concertRepository = concertRepository;
    }

    @PostConstruct
    public void seedDatabase() {
        if (venueRepository.count() > 0 || concertRepository.count() > 0) {
            return; // Skip seeding if already populated
        }

        // VENUES
        Venue msg = new Venue();
        msg.setName("Madison Square Garden");
        msg.setCity("New York");
        msg.setAddress("4 Pennsylvania Plaza");
        msg.setCapacity(20789);
        msg.setIndoor(true);
        msg.setHasParking(true);
        msg.setContactEmail("info@msg.com");
        msg.setContactPhone("123-456-7890");
        msg.setVenueType("Indoor");
        msg.setImageUrl("https://i.scdn.co/image/ab67616d00001e02904445d70d04eb24d6bb79ac/Dq1X1ZJ.jpg");

        Venue forum = new Venue();
        forum.setName("The Forum");
        forum.setCity("Los Angeles");
        forum.setAddress("3900 W Manchester Blvd");
        forum.setCapacity(17500);
        forum.setIndoor(true);
        forum.setHasParking(true);
        forum.setContactEmail("contact@forum.com");
        forum.setContactPhone("987-654-3210");
        forum.setVenueType("Indoor");
        forum.setImageUrl("https://i.scdn.co/image/ab6761610000e5eb4293385d324db8558179afd9/oTZhJZf.jpg");

        Venue wembley = new Venue();
        wembley.setName("Wembley Stadium");
        wembley.setCity("London");
        wembley.setAddress("London HA9 0WS, UK");
        wembley.setCapacity(90000);
        wembley.setIndoor(false);
        wembley.setHasParking(true);
        wembley.setContactEmail("contact@wembley.com");
        wembley.setContactPhone("+44 20 8795 9000");
        wembley.setVenueType("Outdoor");
        wembley.setImageUrl("https://www.billboard.com/wp-content/uploads/2022/01/Coldplay-Credit-James-Marcus-Haney-atlantic-records-2021-billboard-1548.jpg?w=1024/MC2Hlv4.jpg");

        Venue bercy = new Venue();
        bercy.setName("Accor Arena");
        bercy.setCity("Paris");
        bercy.setAddress("8 Blvd de Bercy, 75012 Paris");
        bercy.setCapacity(20000);
        bercy.setIndoor(true);
        bercy.setHasParking(true);
        bercy.setContactEmail("info@accorarena.fr");
        bercy.setContactPhone("+33 1 40 02 60 60");
        bercy.setVenueType("Indoor");
        bercy.setImageUrl("https://www.billboard.com/wp-content/uploads/2022/01/ed-sheeran-credit-DAN_MARTENSEN-2021-billboard-1548.jpg/wxKAj5a.jpg");

        Venue olympic = new Venue();
        olympic.setName("Olympic Stadium");
        olympic.setCity("Berlin");
        olympic.setAddress("Olympischer Platz 3, 14053 Berlin");
        olympic.setCapacity(74000);
        olympic.setIndoor(false);
        olympic.setHasParking(true);
        olympic.setContactEmail("info@olympicstadium.de");
        olympic.setContactPhone("+49 30 30688100");
        olympic.setVenueType("Outdoor");
        olympic.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/3/3b/Olympiastadion_Berlin_Innenraum_2.jpg");

        venueRepository.saveAll(List.of(msg, forum, wembley, bercy, olympic));

        // CONCERTS
        List<Concert> concerts = new ArrayList<>();
        concerts.add(createConcertWithArtist("Taylor Swift", "The Eras Tour", "Pop", "Taylor Swift’s record-breaking world tour",
                LocalDate.of(2025, 7, 15), LocalTime.of(19, 0), "https://i.scdn.co/image/ab67616d00001e02904445d70d04eb24d6bb79ac", msg));

        concerts.add(createConcertWithArtist("Drake", "For All The Dogs Tour", "Hip-Hop", "Drake’s latest album tour",
                LocalDate.of(2025, 8, 22), LocalTime.of(20, 0), "https://i.scdn.co/image/ab6761610000e5eb4293385d324db8558179afd9", forum));

        concerts.add(createConcertWithArtist("Coldplay", "Music of the Spheres World Tour", "Alternative Rock", "Coldplay live in London",
                LocalDate.of(2025, 9, 20), LocalTime.of(19, 30), "https://www.billboard.com/wp-content/uploads/2022/01/Coldplay-Credit-James-Marcus-Haney-atlantic-records-2021-billboard-1548.jpg?w=1024", wembley));

        concerts.add(createConcertWithArtist("Ed Sheeran", "Mathematics Tour", "Pop", "Ed Sheeran’s global stadium tour",
                LocalDate.of(2025, 10, 1), LocalTime.of(20, 0), "https://www.billboard.com/wp-content/uploads/2022/01/ed-sheeran-credit-DAN_MARTENSEN-2021-billboard-1548.jpg", wembley));

        concerts.add(createConcertWithArtist("Dua Lipa", "Future Nostalgia Tour", "Pop", "Dua Lipa live in Paris",
                LocalDate.of(2025, 11, 8), LocalTime.of(21, 0), "https://i.scdn.co/image/ab67616d0000b273a22a7b828934f83ed9901354", bercy));

        concerts.add(createConcertWithArtist("BTS", "Map of the Soul Tour", "K-Pop", "BTS live in Berlin",
                LocalDate.of(2025, 9, 10), LocalTime.of(18, 30), "https://i.scdn.co/image/ab6761610000e5ebd642648235ebf3460d2d1f6a", olympic));

        concerts.add(createConcertWithArtist("The Weeknd", "After Hours Til Dawn", "R&B", "The Weeknd’s international show",
                LocalDate.of(2025, 8, 5), LocalTime.of(20, 30), "https://i.redd.it/gemrdzy9p5w91.jpg", forum));

        concerts.add(createConcertWithArtist("Beyoncé", "Renaissance World Tour", "Pop", "Beyoncé’s groundbreaking stadium tour",
                LocalDate.of(2025, 7, 29), LocalTime.of(19, 30), "https://i.scdn.co/image/ab67616d00001e02ff5429125128b43572dbdccd", msg));

        concerts.add(createConcertWithArtist("Justin Bieber", "Justice World Tour", "Pop", "Justin Bieber live experience",
                LocalDate.of(2025, 10, 10), LocalTime.of(20, 0), "https://i.scdn.co/image/ab6761610000e5eb8ae7f2aaa9817a704a87ea36", bercy));

        concerts.add(createConcertWithArtist("Miley Cyrus", "Endless Summer Vacation", "Pop Rock", "Miley Cyrus live at Olympic Stadium",
                LocalDate.of(2025, 8, 20), LocalTime.of(20, 0), "https://i.scdn.co/image/ab67616d0000b273d6c3ad6a2a27471e1d5e8103", olympic));

        concertRepository.saveAll(concerts);

        System.out.println("Seeded Concerts: " + concertRepository.findAll().size());
        System.out.println("Seeded Venues: " + venueRepository.findAll().size());
    }

    private Concert createConcertWithArtist(String artistName, String title, String genre, String description, LocalDate date, LocalTime time,
                                            String imageUrl, Venue venue) {
        Concert concert = new Concert();
        concert.setArtistName(artistName);
        concert.setTitle(title);
        concert.setGenre(genre);
        concert.setDescription(description);
        concert.setDate(date);
        concert.setTime(time);
        concert.setImageUrl(imageUrl);
        concert.setVenueId(venue.getId());

        TicketType vip = new TicketType();
        vip.setName("VIP");
        vip.setPrice(300);
        vip.setAvailable(100);
        vip.setConcert(concert);

        TicketType general = new TicketType();
        general.setName("General Admission");
        general.setPrice(150);
        general.setAvailable(500);
        general.setConcert(concert);

        concert.setTicketTypes(List.of(vip, general));
        return concert;
    }

}