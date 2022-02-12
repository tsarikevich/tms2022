package com.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@Getter
@SuperBuilder
public class Transport {
    private int horsePower;
    private int maxSpeed;
    private int weight;
    private String model;
    protected final Scanner scanner = new Scanner(System.in);


    public String getInfo() {
        return ("модель - \"" + model + "\""
                + ",\nмощность (л.c.) - " + horsePower
                + ",\nмощность (кВт) - " + kwPower()
                + ",\nмакс. скорость (км\\ч) - " + maxSpeed
                + ",\nвес (кг) - " + weight);
    }

    private double kwPower() {
        double kwPower = (horsePower * 0.74);
        return kwPower;
    }
}
