package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class PassengerTransport extends GroundTransport {
    private String bodyType;
    private int numberOfPassengers;


    @Override
    public String getInfo() {
        return super.getInfo() + ",\nтип кузова - " + bodyType
                + ",\nколичество пассажиров - " + numberOfPassengers;
    }

}
