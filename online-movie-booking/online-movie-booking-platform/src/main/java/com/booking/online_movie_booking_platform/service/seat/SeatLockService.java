package com.booking.online_movie_booking_platform.service.seat;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Service;

import com.booking.online_movie_booking_platform.model.ShowSeat;
import com.booking.online_movie_booking_platform.model.enums.seatStatus;
import com.booking.online_movie_booking_platform.repository.ShowSeatRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class SeatLockService {
    private final ShowSeatRepository showSeatRepository;
    private final EntityManager entityManager;

    private final ConcurrentHashMap<String, Object> showLocks = new ConcurrentHashMap<>();

    public SeatLockService(ShowSeatRepository showSeatRepository, EntityManager entityManager) {
        this.showSeatRepository = showSeatRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public void lockSeats(String showId, List<String> seatIds) {
        List<ShowSeat> seats = showSeatRepository.findByShowId(showId).stream()
                .filter(seat -> seatIds.contains(seat.getSeat().getId()))
                .toList();

        if(!seats.stream().allMatch(seat -> seat.getStatus() == seatStatus.AVAILABLE)) {
            throw new RuntimeException("One or more seats are not available");
        }

        Object lock = showLocks.computeIfAbsent(showId, id -> new Object());
        synchronized (lock) {
            seats.forEach(seat -> entityManager.lock(seat, jakarta.persistence.LockModeType.PESSIMISTIC_WRITE));
            if(!seats.stream().allMatch(seat -> seat.getStatus() == seatStatus.AVAILABLE)) {
                throw new RuntimeException("One or more seats are not available");
            }
            seats.forEach(seat -> seat.setStatus(seatStatus.RESERVED));
            showSeatRepository.saveAll(seats);
        }
    }
}
