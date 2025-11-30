package com.railway.reservation.controller;

import com.railway.reservation.model.Booking;
import com.railway.reservation.service.InMemoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final InMemoryService service;

    public BookingController(InMemoryService service) {
        this.service = service;
    }

    @PostMapping("/book")
    public Booking book(@RequestBody Map<String, String> request) {
        String trainId = request.get("trainId");
        String passengerName = request.get("passenger");
        int seats = Integer.parseInt(request.get("seats"));

        return service.bookTicket(trainId, passengerName, seats);
    }
}
