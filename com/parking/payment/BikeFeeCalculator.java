package com.parking.payment;


// Fee Calculators for different vehicle types
public class BikeFeeCalculator implements FeeCalculator {
    @Override
    public int generateFee(long hours) {
        return (int) hours * 30;
    }
}
