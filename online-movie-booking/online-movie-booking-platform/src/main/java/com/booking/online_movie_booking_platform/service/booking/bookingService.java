package com.booking.online_movie_booking_platform.service.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.online_movie_booking_platform.model.Booking;
import com.booking.online_movie_booking_platform.model.BookingSeat;
import com.booking.online_movie_booking_platform.model.ShowSeat;
import com.booking.online_movie_booking_platform.model.enums.bookingStatus;
import com.booking.online_movie_booking_platform.model.enums.seatStatus;
import com.booking.online_movie_booking_platform.repository.BookingRepository;
import com.booking.online_movie_booking_platform.repository.BookingSeatRepository;
import com.booking.online_movie_booking_platform.repository.ShowSeatRepository;
import com.booking.online_movie_booking_platform.service.seat.SeatLockService;

import jakarta.transaction.Transactional;

@Service
public class bookingService {

    private final ShowSeatRepository showSeatRepository;
    private final BookingRepository bookingRepository;
    private final BookingSeatRepository bookingSeatRepository;
    private final SeatLockService seatLockService;

    public bookingService(ShowSeatRepository showSeatRepository, BookingRepository bookingRepository,
            BookingSeatRepository bookingSeatRepository, SeatLockService seatLockService) {
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.bookingSeatRepository = bookingSeatRepository;
        this.seatLockService = seatLockService;
    }


    @Transactional
    public Booking bookTickets(String userId, String showId, List<String> seat_Ids) {
        // Step 1: Lock the seats
        seatLockService.lockSeats(showId, seat_Ids);
        // Step 2: Fetch Reserved Seats
        List<ShowSeat> reservedSeats = showSeatRepository.findByShowId(showId).stream()
                .filter(seat -> seat_Ids.contains(seat.getSeat().getId()) && seat.getStatus() == seatStatus.RESERVED)
                .toList();
        if(reservedSeats.size() != seat_Ids.size()) {
            throw new RuntimeException("One or more seats could not be reserved");
        }
        // Step 3: Mark as Booked
        reservedSeats.forEach(seat -> seat.setStatus(seatStatus.BOOKED));
        showSeatRepository.saveAll(reservedSeats);
        // Step 4: Create Booking Record
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setShowId(showId);
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus(bookingStatus.CONFIRMED);
        booking.setTotalPrice(calculateTotalPrice(reservedSeats));
        booking = bookingRepository.save(booking);
        // Step 5: Create BookingSeat Records
        List<BookingSeat> bookingSeats = new ArrayList<>();
        for(ShowSeat seat : reservedSeats) {
            BookingSeat bookingSeat = new BookingSeat();
            bookingSeat.setBookingId(booking.getId());
            bookingSeat.setSeatId(seat.getId());
            bookingSeats.add(bookingSeat);
        }
        bookingSeatRepository.saveAll(bookingSeats);

        return booking;

    }

    private double calculateTotalPrice(List<ShowSeat> seats) {
        return (seats.size() * 200.0); // Assuming each seat costs 200.0
    }

}
