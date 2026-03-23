package com.booking.online_movie_booking_platform.service.theatre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.online_movie_booking_platform.model.Seat;
import com.booking.online_movie_booking_platform.model.Show;
import com.booking.online_movie_booking_platform.model.ShowSeat;
import com.booking.online_movie_booking_platform.model.enums.seatStatus;
import com.booking.online_movie_booking_platform.repository.SeatRepository;
import com.booking.online_movie_booking_platform.repository.ShowRepository;
import com.booking.online_movie_booking_platform.repository.ShowSeatRepository;

import jakarta.transaction.Transactional;

@Service
public class ShowManagementService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Transactional
    public Show createShow(Show show, String screen_id) {
        // Create the show
        show = showRepository.save(show);
        List<Seat> seats = seatRepository.findByScreenId(screen_id);
        // Create ShowSeat entries for each seat in the screen
        List<ShowSeat> showSeats = new ArrayList<>();
        for(Seat seat : seats) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setShow(show);
            showSeat.setSeat(seat);
            showSeat.setStatus(seatStatus.AVAILABLE);
            showSeats.add(showSeat);
        }
        showSeatRepository.saveAll(showSeats);
        return show;
    }

    public Show updateShow(String showId, LocalDateTime newTime) {
        Show show = showRepository.findById(showId)
        .orElseThrow(() -> new RuntimeException("Show not found"));
        show.setShowTime(newTime);
        return showRepository.save(show);
    }

    @Transactional
    public void deleteShow(String showId) {
        List<ShowSeat> showSeats = showSeatRepository.findByShowId(showId);
        showSeatRepository.deleteAll(showSeats);
        showRepository.deleteById(showId);
    }
}
