package com.railway.reservation.controller;

import com.railway.reservation.model.Booking;
import com.railway.reservation.service.InMemoryService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> book(@RequestBody Map<String, Object> request) {
        try {
            String trainId = (String) request.get("trainId");
            String passenger = (String) request.get("passenger");
            int seats = Integer.parseInt(request.get("seats").toString());

            Booking booking = service.bookTicket(trainId, passenger, seats);
            return ResponseEntity.ok(booking);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid request data");
        }
    }
}
