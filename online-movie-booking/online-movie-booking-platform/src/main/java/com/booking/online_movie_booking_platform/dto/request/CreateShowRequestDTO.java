package com.booking.online_movie_booking_platform.dto.request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShowRequestDTO {
    private String movieID;
    private String screenID;
    private LocalDateTime showTime; // ISO 8601 format
    private double price;
}
