package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class MillitaryTransport extends AirTransport {
    private boolean isEjectionSystem;
    private int numberOfRockets;

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
