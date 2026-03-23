package com.booking.online_movie_booking_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.online_movie_booking_platform.model.ShowSeat;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, String> {
    List<ShowSeat> findByShowId(String showId);

    public void deleteAll(List<ShowSeat> showSeats);

    public List<ShowSeat> findSeatsForUpdate(String showId, List<String> seat_Ids);
}

