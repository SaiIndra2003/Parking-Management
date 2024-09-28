package com.parking.space;

import com.parking.vehicle.VehicleType;

public class CarParkingSpace extends ParkingSpace {
    public CarParkingSpace(int capacity) {
        super(VehicleType.CAR, capacity);
    }
}
