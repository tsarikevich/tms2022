package com.tms.model;


public class CargoTransport extends GroundTransport {
    private int loadCapacity;

    public CargoTransport(int horsePower, int maxSpeed, int weight, String model, int numberOfWheels, double fuelConsumption, int loadCapacity) {
        super(horsePower, maxSpeed, weight, model, numberOfWheels, fuelConsumption);
        this.loadCapacity = loadCapacity;
    }


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
