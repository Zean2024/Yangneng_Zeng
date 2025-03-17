package com.example;

public class AsphaltCar extends RallyCar {
    public AsphaltCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return getHorsepower() * 1.2; // the performance calculation for asphalt
    }
}