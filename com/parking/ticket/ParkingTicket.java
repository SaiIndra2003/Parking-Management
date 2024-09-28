package com.parking.ticket;

import com.parking.vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

// ParkingTicket to store entry times and vehicle details
public class ParkingTicket {
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;

    public ParkingTicket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();  // Entry time is the current time
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    // Method to calculate the hours parked dynamically
    public long getHoursParked() {
        LocalDateTime exitTime = LocalDateTime.now();  // Exit time is the current time
        Duration duration = Duration.between(entryTime, exitTime);
        return Math.max(duration.toHours(), 1);  // At least 1 hour charged
    }
}
