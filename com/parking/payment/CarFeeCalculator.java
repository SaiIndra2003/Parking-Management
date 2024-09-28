package com.parking.payment;


public class CarFeeCalculator implements FeeCalculator {
    @Override
    public int generateFee(long hours) {
        return (int) hours * 60;
    }
}
