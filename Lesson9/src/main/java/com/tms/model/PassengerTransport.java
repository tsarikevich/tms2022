package com.tms.model;


public class PassengerTransport extends GroundTransport {
    private String bodyType;
    private int numberOfPassengers;


    public PassengerTransport(int horsePower, int maxSpeed, int weight, String model, int numberOfWheels, double fuelConsumption, String bodyType, int numberOfPassengers) {
        super(horsePower, maxSpeed, weight, model, numberOfWheels, fuelConsumption);
        this.bodyType = bodyType;
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ",\nтип кузова - " + bodyType
                + ",\nколичество пассажиров - " + numberOfPassengers;
    }

}
