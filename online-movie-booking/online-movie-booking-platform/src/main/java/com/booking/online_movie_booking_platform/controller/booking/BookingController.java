package com.booking.online_movie_booking_platform.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.online_movie_booking_platform.dto.request.BookingRequestDTO;
import com.booking.online_movie_booking_platform.dto.response.BookingResponseDTO;
import com.booking.online_movie_booking_platform.model.Booking;
import com.booking.online_movie_booking_platform.service.booking.bookingService;


@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private bookingService bookingService;

    @PostMapping
    public BookingResponseDTO bookTickets(@RequestBody BookingRequestDTO request) {
        Booking booking = bookingService.bookTickets(
            request.getUserId(),
            request.getShowId(),
            request.getSeatIds()
        );
        BookingResponseDTO response = new BookingResponseDTO();
        response.setBookingID(booking.getId());
        response.setStatus(booking.getStatus().name());
        response.setTotalPrice(booking.getTotalPrice());
        return response;
    }
    

}
