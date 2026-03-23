package com.booking.online_movie_booking_platform.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponseDTO {
    private String id;
    private String name;
    private String genre;
    private String language;
    private int duration; // in minutes
}
