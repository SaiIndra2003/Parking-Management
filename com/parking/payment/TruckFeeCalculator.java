package com.parking.payment;

public class TruckFeeCalculator implements FeeCalculator {
    @Override
    public int generateFee(long hours) {
        return (int) hours * 80;
    }
}
