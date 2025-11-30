package com.railway.reservation.model;

public class Train {
    private String id;
    private String name;
    private String from;
    private String to;
    private int seatsAvailable;

    public Train() {}

    public Train(String id, String name, String from, String to, int seatsAvailable) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.seatsAvailable = seatsAvailable;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public int getSeatsAvailable() { return seatsAvailable; }
    public void setSeatsAvailable(int seatsAvailable) { this.seatsAvailable = seatsAvailable; }

    public int getSeats() { return seatsAvailable; }

    public void bookSeats(int count) {
        if (count <= seatsAvailable) {
            seatsAvailable -= count;
        } else {
            throw new IllegalArgumentException("Not enough seats available");
        }
    }
}
