package com.parking.space;

import com.parking.ticket.ParkingTicket;
import com.parking.vehicle.Vehicle;
import com.parking.vehicle.VehicleType;

import java.util.ArrayList;

// ParkingSpace (abstract) - to manage vehicles and parking space capacity
public abstract class ParkingSpace {
    private final ArrayList<ParkingTicket> tickets;
    private final VehicleType spotType;
    private final int capacity;
    private int currentCapacity;

    public ParkingSpace(VehicleType spotType, int capacity) {
        this.tickets = new ArrayList<>();
        this.spotType = spotType;
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() == spotType && currentCapacity < capacity) {
            tickets.add(new ParkingTicket(vehicle));
            currentCapacity++;
            return true;
        }
        return false;
    }

    public ParkingTicket free(Vehicle vehicle) {
        for (ParkingTicket ticket : tickets) {
            if (ticket.getVehicle().equals(vehicle)) {
                tickets.remove(ticket);
                currentCapacity--;
                return ticket;  // Return the ticket to calculate parking duration
            }
        }
        return null;  // Vehicle not found
    }

    public boolean isAvailable() {
        return currentCapacity < capacity;
    }
}
