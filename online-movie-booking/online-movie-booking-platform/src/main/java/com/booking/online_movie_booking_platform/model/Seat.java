package com.booking.online_movie_booking_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seats")
@Getter @Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String rowNumber;
    private int seatNumber;
    private String type; // Recliner, Premium, Gold, Silver;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
}
