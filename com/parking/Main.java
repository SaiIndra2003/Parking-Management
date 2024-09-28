package com.parking;

import com.parking.manager.ParkingManager;

import com.parking.payment.*;
import com.parking.vehicle.*;
import com.parking.space.BikeParkingSpace;
import com.parking.space.CarParkingSpace;
import com.parking.space.ParkingSpace;
import com.parking.space.TruckParkingSpace;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Dynamic Parking Space Setup
        Map<VehicleType, ParkingSpace> parkingSpaces = new HashMap<>();
        parkingSpaces.put(VehicleType.BIKE, new BikeParkingSpace(10));
        parkingSpaces.put(VehicleType.CAR, new CarParkingSpace(5));
        parkingSpaces.put(VehicleType.TRUCK, new TruckParkingSpace(2));

        // Dynamic Fee Calculator Setup
        Map<VehicleType, FeeCalculator> feeCalculators = new HashMap<>();
        feeCalculators.put(VehicleType.BIKE, new BikeFeeCalculator());
        feeCalculators.put(VehicleType.CAR, new CarFeeCalculator());
        feeCalculators.put(VehicleType.TRUCK, new TruckFeeCalculator());

        PaymentManager paymentManager = new PaymentManager(feeCalculators);

        ParkingManager parkingManager = new ParkingManager(parkingSpaces, paymentManager);

        // Create some vehicles
        Vehicle car = new Car("12345");
        Vehicle bike = new Bike("13245");
        Vehicle truck = new Truck("15234");

        // Park vehicles
        parkingManager.parkVehicle(car);
        parkingManager.parkVehicle(bike);
        parkingManager.parkVehicle(truck);



        // Free vehicles and calculate fees
        parkingManager.freeVehicle(car);
        parkingManager.freeVehicle(bike);
        parkingManager.freeVehicle(truck);
    }

}
