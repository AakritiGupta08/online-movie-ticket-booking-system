package com.booking.online_movie_booking_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.online_movie_booking_platform.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
    List<Seat> findByScreenId(String screenId);
}
