package com.tms.model;


public class AirTransport extends Transport {
    private double wingspan;
    private int minimumRunwayLength;

    public AirTransport(int horsePower, int maxSpeed, int weight, String model, double wingspan, int minimumRunwayLength) {
        super(horsePower, maxSpeed, weight, model);
        this.wingspan = wingspan;
        this.minimumRunwayLength = minimumRunwayLength;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ",\nразмах крыльев (м) - " + wingspan
                + ",\nминимальная длина взлётно-посадочной полосы для взлёта (м) - " + minimumRunwayLength;
    }
}

