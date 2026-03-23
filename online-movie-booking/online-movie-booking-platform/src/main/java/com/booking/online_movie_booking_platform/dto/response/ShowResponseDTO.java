package com.booking.online_movie_booking_platform.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowResponseDTO {
    private String showID;
    private String movieName;
    private LocalDateTime showTime;
    private double price;
}
