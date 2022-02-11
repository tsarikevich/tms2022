package com.tms.model;


public class CivilTransport extends AirTransport {
    private int numberOfPassenger;
    private boolean isBusinessClass;

    public CivilTransport(int horsePower, int maxSpeed, int weight, String model, double wingspan, int minimumRunwayLength, int numberOfPassenger, boolean isBussinesClass) {
        super(horsePower, maxSpeed, weight, model, wingspan, minimumRunwayLength);
        this.numberOfPassenger = numberOfPassenger;
        this.isBusinessClass = isBussinesClass;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ",\nколичество пассажиров - " + numberOfPassenger
                + ",\nналичие бизнес-класса - " + getNameVariable();
    }

    private String getNameVariable() {
        if (isBusinessClass) {
            return "есть";
        }
        return "нет";
    }

    public void checkNumberOfPassengers() {
        System.out.println("Введите необходимое количество пассажиров");
        int passengers = scanner.nextInt();
        if (passengers <= numberOfPassenger) {
            System.out.println("Пассажиры размещены в самолете");

        } else {
            System.out.println("Нужен самолет побольше");
        }
    }
}
