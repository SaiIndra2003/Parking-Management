package com.parking.space;

import com.parking.vehicle.VehicleType;

public class TruckParkingSpace extends ParkingSpace {
    public TruckParkingSpace(int capacity) {
        super(VehicleType.TRUCK, capacity);
    }
}
