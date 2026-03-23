package com.booking.online_movie_booking_platform.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {
    private String bookingID;
    private String status;
    private double totalPrice;
    public List<String> seatIds;
}
