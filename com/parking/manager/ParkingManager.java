package com.parking.manager;

import com.parking.space.ParkingSpace;

import com.parking.ticket.ParkingTicket;


import com.parking.vehicle.Vehicle;
import com.parking.vehicle.VehicleType;
import com.parking.payment.PaymentManager;

import java.util.Map;



// ParkingManager to manage parking and freeing of vehicles
public class ParkingManager {
    private final Map<VehicleType, ParkingSpace> parkingLot;
    private final PaymentManager paymentManager;

    public ParkingManager(Map<VehicleType, ParkingSpace> parkingLot, PaymentManager paymentManager) {
        this.parkingLot = parkingLot;
        this.paymentManager = paymentManager;
    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSpace parkingSpace = parkingLot.get(vehicle.getVehicleType());
        if (parkingSpace != null && parkingSpace.isAvailable()) {
            boolean isParked = parkingSpace.parkVehicle(vehicle);
            if (isParked) {
                System.out.println(vehicle.getVehicleType() + " is parked.");
            } else {
                System.out.println("Invalid Vehicle...");
            }
        } else {
            System.out.println("No parking space for " + vehicle.getVehicleType() + "s");
        }
    }

    public void freeVehicle(Vehicle vehicle) {
        ParkingSpace parkingSpace = parkingLot.get(vehicle.getVehicleType());
        if (parkingSpace != null) {
            ParkingTicket ticket = parkingSpace.free(vehicle);
            if (ticket != null) {
                long hoursParked = ticket.getHoursParked();  // Calculate parking duration dynamically
                paymentManager.processPayment(vehicle, hoursParked);
            } else {
                System.out.println("Vehicle not found in parking lot.");
            }
        }
    }
}


