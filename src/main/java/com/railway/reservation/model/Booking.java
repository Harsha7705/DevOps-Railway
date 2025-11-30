package com.railway.reservation.model;

import java.util.UUID;

public class Booking {

    private String bookingId;
    private String trainId;
    private String passengerName;
    private int seatsBooked;

    public Booking() {}

    public Booking(String trainId, String passengerName, int seatsBooked) {
        this.bookingId = UUID.randomUUID().toString();
        this.trainId = trainId;
        this.passengerName = passengerName;
        this.seatsBooked = seatsBooked;
    }

    public String getBookingId() { return bookingId; }
    public String getTrainId() { return trainId; }
    public void setTrainId(String trainId) { this.trainId = trainId; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public int getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(int seatsBooked) { this.seatsBooked = seatsBooked; }
}
