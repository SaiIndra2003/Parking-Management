package com.parking.vehicle;


// com.indra.paymentmanager.Vehicle Implementations
public class Bike implements Vehicle {
    private final String licensePlate;

    public Bike(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }
}
