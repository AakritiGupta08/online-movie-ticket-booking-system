package com.booking.online_movie_booking_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.online_movie_booking_platform.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

}
