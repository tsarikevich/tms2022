package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class GroundTransport extends Transport {
    private int numberOfWheels;
    private double fuelConsumption;
    private double distance;


    @Override
    public String getInfo() {
        return super.getInfo() + ",\nколичество колёс - " + numberOfWheels
                + ",\nрасход топлива (л\\100км) - " + fuelConsumption;
    }

    public void groundTransportInfo() {
        System.out.println("Введите время езды (в часах) для " + getModel() + ":");
        double time = scanner.nextDouble();
        distance = getMaxSpeed() * time;
        System.out.println("За время " + time + " ч, автомобиль " + getModel() +
                " двигаясь с максимальной скоростью " + getMaxSpeed() +
                " км\\ч проедет " + distance + " км и израсходует " + getNumberOfFuel() + " литров топлива");
    }

    private double getNumberOfFuel() {
        double fuel = (distance / 100) * fuelConsumption;
        return fuel;
    }
}
