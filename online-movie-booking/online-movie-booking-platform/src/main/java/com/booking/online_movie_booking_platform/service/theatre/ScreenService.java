package com.booking.online_movie_booking_platform.service.theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.online_movie_booking_platform.model.Screen;
import com.booking.online_movie_booking_platform.repository.ScreenRepository;

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    public Screen createScreen(Screen screen) {
        return screenRepository.save(screen);
    }
}
