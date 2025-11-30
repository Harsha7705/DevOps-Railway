package com.railway.reservation.controller;

import com.railway.reservation.service.InMemoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private final InMemoryService service;

    public WebController(InMemoryService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("trains", service.getAllTrains());
        return "index";
    }

    @GetMapping("/booking")
    public String bookingPage(Model model) {
        model.addAttribute("trains", service.getAllTrains());
        return "booking";
    }

    @PostMapping("/book")
    public String bookTicket(@RequestParam String trainId,
                             @RequestParam String passenger,
                             @RequestParam int seats,
                             Model model) {
        try {
            service.bookTicket(trainId, passenger, seats);
            model.addAttribute("message", "Ticket booked successfully!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Booking failed: " + e.getMessage());
        }
        model.addAttribute("trains", service.getAllTrains());
        return "index";
    }
}
