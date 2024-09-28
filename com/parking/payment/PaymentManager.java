package com.parking.payment;

import com.parking.vehicle.VehicleType;
import com.parking.vehicle.Vehicle;

import java.util.Map;

// com.indra.paymentmanager.PaymentManager to handle fee calculation
public class PaymentManager {
    private final Map<VehicleType, FeeCalculator> feeCalculators;

    public PaymentManager(Map<VehicleType, FeeCalculator> feeCalculators) {
        this.feeCalculators = feeCalculators;
    }

    public void processPayment(Vehicle vehicle, long hoursParked) {
        FeeCalculator calculator = feeCalculators.get(vehicle.getVehicleType());
        if (calculator != null) {
            int fees = calculator.generateFee(hoursParked);
            System.out.println("Fee for " + vehicle.getVehicleType() + ": " + vehicle.getLicensePlate() + " is: $" + fees);
        } else {
            System.out.println("No fee calculator available for " + vehicle.getVehicleType());
        }
    }
}
