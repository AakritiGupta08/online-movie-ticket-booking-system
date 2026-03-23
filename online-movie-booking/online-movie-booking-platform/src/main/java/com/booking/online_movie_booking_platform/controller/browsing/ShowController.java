package com.booking.online_movie_booking_platform.controller.browsing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.online_movie_booking_platform.model.Show;
import com.booking.online_movie_booking_platform.model.ShowSeat;
import com.booking.online_movie_booking_platform.service.browsing.ShowService;

@RestController
@RequestMapping("/api/shows")
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{showId}/seats")
    public List<ShowSeat> getSeatsForShow(@PathVariable String showId) {
        return showService.getSeatsForShow(showId);
    }
}
