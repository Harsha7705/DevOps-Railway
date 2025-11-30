package com.railway.reservation.controller;

import com.railway.reservation.service.InMemoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainController {

    private final InMemoryService service;

    public TrainController(InMemoryService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("trains", service.getAllTrains());
        return "index"; 
    }
}
