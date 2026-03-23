package com.booking.online_movie_booking_platform.service.browsing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.online_movie_booking_platform.model.Show;
import com.booking.online_movie_booking_platform.model.ShowSeat;
import com.booking.online_movie_booking_platform.repository.ShowRepository;
import com.booking.online_movie_booking_platform.repository.ShowSeatRepository;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public List<ShowSeat> getSeatsForShow(String showId) {
        return showSeatRepository.findByShowId(showId);
    }
}
