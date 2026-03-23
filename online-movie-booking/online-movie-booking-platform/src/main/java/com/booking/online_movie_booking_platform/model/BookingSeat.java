package com.booking.online_movie_booking_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking_seats")
@Getter @Setter
public class BookingSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @OneToOne
    @JoinColumn(name = "show_seat_id")
    private ShowSeat showSeat;

    public void setBookingId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSeatId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
