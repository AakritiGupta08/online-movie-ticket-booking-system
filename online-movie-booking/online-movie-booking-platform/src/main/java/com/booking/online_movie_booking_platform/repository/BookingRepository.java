package com.booking.online_movie_booking_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.online_movie_booking_platform.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    public Booking save(Booking booking);

}
