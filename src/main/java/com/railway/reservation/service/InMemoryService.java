package com.railway.reservation.service;

import com.railway.reservation.model.Booking;
import com.railway.reservation.model.Train;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryService {

    private final Map<String, Train> trains = new ConcurrentHashMap<>();
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        trains.put("T1", new Train("T1", "Shatabdi Express", "Hyderabad", "Vijayawada", 100));
        trains.put("T2", new Train("T2", "Rajdhani Express", "Hyderabad", "Delhi", 120));
        trains.put("T3", new Train("T3", "Chennai Express", "Vijayawada", "Chennai", 150));
    }

    public List<Train> getAllTrains() {
        return new ArrayList<>(trains.values());
    }

    public Booking bookTicket(String trainId, String passengerName, int seats) {

        Train train = trains.get(trainId);

        if (train == null) {
            throw new IllegalArgumentException("Train ID not found");
        }

        if (train.getSeatsAvailable() < seats) {
            throw new IllegalStateException("Not enough seats available");
        }

        train.setSeatsAvailable(train.getSeatsAvailable() - seats);

        Booking booking = new Booking(trainId, passengerName, seats);
        bookings.put(booking.getBookingId(), booking);

        return booking;
    }
}
