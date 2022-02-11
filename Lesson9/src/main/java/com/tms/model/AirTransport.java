package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class AirTransport extends Transport {
    private double wingspan;
    private int minimumRunwayLength;


    @Override
    public String getInfo() {
        return super.getInfo() + ",\nразмах крыльев (м) - " + wingspan
                + ",\nминимальная длина взлётно-посадочной полосы для взлёта (м) - " + minimumRunwayLength;
    }
}

