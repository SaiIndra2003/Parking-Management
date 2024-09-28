package com.parking.vehicle;

public class Truck implements Vehicle {
    private final String licensePlate;

    public Truck(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TRUCK;
    }
}
