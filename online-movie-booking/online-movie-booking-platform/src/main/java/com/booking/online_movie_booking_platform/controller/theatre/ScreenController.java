package com.booking.online_movie_booking_platform.controller.theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.online_movie_booking_platform.model.Screen;
import com.booking.online_movie_booking_platform.service.theatre.ScreenService;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {
    @Autowired
    private ScreenService screenService;

    @PostMapping
    public Screen createScreen(@RequestBody Screen screen) {
        return screenService.createScreen(screen);
    }
}
