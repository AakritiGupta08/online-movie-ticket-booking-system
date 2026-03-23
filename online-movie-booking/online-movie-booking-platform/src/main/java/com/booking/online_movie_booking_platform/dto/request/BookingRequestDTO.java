package com.booking.online_movie_booking_platform.dto.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDTO {
    private String userID;
    private String showID;
    public List<String> seatIds;
    public String getUserId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserId'");
    }
    public String getShowId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShowId'");
    }

    public List<String> getSeatIds() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
