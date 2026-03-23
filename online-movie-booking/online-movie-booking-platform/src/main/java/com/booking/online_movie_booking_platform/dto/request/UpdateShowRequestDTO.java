package com.booking.online_movie_booking_platform.dto.request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateShowRequestDTO {
    private LocalDateTime showTime;
}
