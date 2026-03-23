package com.booking.online_movie_booking_platform.controller.theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.online_movie_booking_platform.dto.request.CreateShowRequestDTO;
import com.booking.online_movie_booking_platform.dto.request.UpdateShowRequestDTO;
import com.booking.online_movie_booking_platform.dto.response.ShowResponseDTO;
import com.booking.online_movie_booking_platform.model.Show;
import com.booking.online_movie_booking_platform.service.theatre.ShowManagementService;

@RestController
@RequestMapping("/api/admin/shows")
public class ShowManagementController {
    @Autowired
    private ShowManagementService showManagementService;

    @PostMapping
    public ShowResponseDTO createShow(@RequestBody CreateShowRequestDTO request) {
        Show show = new Show();
        show.setShowTime(request.getShowTime());
        show.setPrice(request.getPrice());
        Show savedShow = showManagementService.createShow(show, request.getScreenID());
        return mapToResponse(savedShow);
    }

    @PutMapping("/{showId}")
    public ShowResponseDTO updateShow(@PathVariable String showId, @RequestBody UpdateShowRequestDTO request) {
        Show updatedShow = showManagementService.updateShow(showId, request.getShowTime());
        return mapToResponse(updatedShow);
    }

    @DeleteMapping("/{showId}")
    public String deleteShow(@PathVariable String showId) {
        showManagementService.deleteShow(showId);
        return "Show with ID " + showId + " has been deleted.";
    }

    private ShowResponseDTO mapToResponse(Show show) {
        ShowResponseDTO response = new ShowResponseDTO();
        response.setShowID(show.getId());
        response.setShowTime(show.getShowTime());
        response.setPrice(show.getPrice());
        return response;
    }
}

