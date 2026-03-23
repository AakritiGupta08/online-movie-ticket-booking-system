package com.booking.online_movie_booking_platform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.online_movie_booking_platform.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, String> {

    public Show save(Show show);

    public void deleteById(String showId);

    public Optional<Show> findById(String showId);

}
