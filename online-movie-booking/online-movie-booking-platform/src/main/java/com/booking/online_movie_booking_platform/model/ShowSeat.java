package com.booking.online_movie_booking_platform.model;

import java.time.LocalDateTime;

import com.booking.online_movie_booking_platform.model.enums.seatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "show_seats")
@Getter @Setter
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private seatStatus status;

    private String lockedBy; // User ID who has locked the seat
    private LocalDateTime lockTime; // Time when the seat was locked

    @Version
    private int version; // For optimistic locking

    public String getSeatId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSeatId'");
    }

    public void setStatus(seatStatus seatStatus) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public seatStatus getStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setShow(Show show) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSeat(Seat seat) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
