package by.tms.robot.legs;

import lombok.ToString;

@ToString
public class SamsungLeg implements ILeg {
    private int price;

    public SamsungLeg(int price) {
        this.price = price;
    }

    public SamsungLeg() {
    }

    @Override
    public void step() {
        System.out.println("Сделан шаг ногой Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
