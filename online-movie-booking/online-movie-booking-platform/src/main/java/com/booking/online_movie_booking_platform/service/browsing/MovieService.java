package com.booking.online_movie_booking_platform.service.browsing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.online_movie_booking_platform.model.Movie;
import com.booking.online_movie_booking_platform.repository.MovieRepository;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
