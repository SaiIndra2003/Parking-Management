package com.parking.vehicle;

public class Car implements Vehicle {
    private final String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
