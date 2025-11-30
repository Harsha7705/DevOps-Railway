package com.railway.reservation.controller;

import com.railway.reservation.service.InMemoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final InMemoryService service;

    public WebController(InMemoryService service) {
        this.service = service;
    }

    // Home page showing all trains
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("trains", service.getAllTrains());
        return "index"; // renders index.html
    }

    // Booking page with form
    @GetMapping("/booking")
    public String bookingPage(Model model) {
        model.addAttribute("trains", service.getAllTrains());
        return "booking"; // renders booking.html
    }

    // Handle booking form submission
    @PostMapping("/book")
    public String bookTicket(@RequestParam String trainId,
                             @RequestParam String passenger,
                             @RequestParam int seats,
                             Model model) {

        // Call service to book ticket
        service.bookTicket(trainId, passenger, seats);

        // Add success message and updated train list
        model.addAttribute("message", "Ticket booked successfully!");
        model.addAttribute("trains", service.getAllTrains());

        return "index"; // return to home page with updated seats
    }
}
