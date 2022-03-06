package com.tms.task4;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 4) Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров), бак(тип топлива, объем), скорость, цена).
 * Количество цилиндров не должно сереализоватся в файл(это конфедициальная информация)
 * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль
 */
@ToString
public class Car implements Serializable {
    private String model;
    private double speed;
    private double price;
    private Engine engine;
    private Tank tank;

    public Car(String model, String typeEngine, int numbersCylinder, String typeFuel, int capacity, double speed, double price) {
        this.model = model;
        this.speed = speed;
        this.price = price;
        this.engine = new Engine(typeEngine, numbersCylinder);
        this.tank = new Tank(typeFuel, capacity);
    }

    @AllArgsConstructor
    @ToString
    private class Engine implements Serializable {
        private String type;
        private transient int numbersCylinder;

    }

    @AllArgsConstructor
    @ToString
    private class Tank implements Serializable {
        private String typeFuel;
        private int capacity;
    }


}
