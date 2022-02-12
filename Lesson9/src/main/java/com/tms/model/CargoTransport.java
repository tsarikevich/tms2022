package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class CargoTransport extends GroundTransport {
    private int loadCapacity;


    @Override
    public String getInfo() {
        return super.getInfo()
                + ",\nгрузоподьемность (т) - " + loadCapacity;
    }

    public void checkCapacity() {
        System.out.println("Введите количество груза в тоннах:");
        double capacity = scanner.nextDouble();
        if (capacity <= loadCapacity) {
            System.out.println("Грузовик " + getModel() + " загружен");
        } else {
            System.out.println("Вам нужен грузовик побольше");
        }
    }
}
