package com.booking.online_movie_booking_platform.service.theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.online_movie_booking_platform.model.Theatre;
import com.booking.online_movie_booking_platform.repository.TheatreRepository;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }
}
