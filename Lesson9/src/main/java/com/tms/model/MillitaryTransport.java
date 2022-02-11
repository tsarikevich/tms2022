package com.tms.model;


public class MillitaryTransport extends AirTransport {
    private boolean isEjectionSystem;
    private int numberOfRockets;

    public MillitaryTransport(int horsePower, int maxSpeed, int weight, String model, double wingspan, int minimumRunwayLength, boolean isEjectionSystem, int numberOfRockets) {
        super(horsePower, maxSpeed, weight, model, wingspan, minimumRunwayLength);
        this.isEjectionSystem = isEjectionSystem;
        this.numberOfRockets = numberOfRockets;
    }

    @Override
    public String getInfo() {
        return super.getInfo()
                + ",\nналичие системы катапультирования - " + getNameVariable()
                + ",\nколичество ракет - " + numberOfRockets;
    }

    private String getNameVariable() {
        if (isEjectionSystem) {
            return "есть";
        }
        return "нет";
    }

    public void shot() {
        if (numberOfRockets > 0) {
            System.out.println("Ракета пошла");
            numberOfRockets--;
        } else {
            System.out.println("Снаряды отсутствуют");
        }
    }

    public void ejection() {
        if (isEjectionSystem) {
            System.out.println("Катапультирование из " + getModel() + " прошло успешно");
        } else {
            System.out.println("У Вас (в " + getModel() + ") нет такой системы.");
        }
    }
}
