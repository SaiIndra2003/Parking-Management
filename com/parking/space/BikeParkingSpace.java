package com.parking.space;

import com.parking.vehicle.VehicleType;

// Specific ParkingSpace Implementations for different vehicle types
public class BikeParkingSpace extends ParkingSpace {
    public BikeParkingSpace(int capacity) {
        super(VehicleType.BIKE, capacity);
    }
}
