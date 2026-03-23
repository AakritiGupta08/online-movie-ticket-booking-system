package com.booking.online_movie_booking_platform.model;

import java.time.LocalDateTime;
import java.util.List;

import com.booking.online_movie_booking_platform.model.enums.bookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@Getter @Setter

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private bookingStatus status;

    private LocalDateTime bookingTime;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @OneToMany(mappedBy = "booking")
    private List<ShowSeat> bookedSeats;

    public void setShowId(String showId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void setCreatedAt(LocalDateTime now) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
