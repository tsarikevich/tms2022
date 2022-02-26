package com.tms.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private String model;
    private double speed;
    private double price;

    public void start() throws CarException {
        Random random = new Random();
        int number = random.nextInt(21);
        System.out.println("Случайное число - " + number);
        if (number % 2 == 0) {
            throw new CarException(getModel() + " не завелась");
        } else {
            System.out.println(getModel() + " завелась");
        }


    }
}
