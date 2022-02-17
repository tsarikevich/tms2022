package by.tms.robot.legs;

import lombok.ToString;

@ToString
public class SonyLeg implements ILeg {
    private int price;

    public SonyLeg(int price) {
        this.price = price;
    }

    public SonyLeg() {
    }

    @Override
    public void step() {
        System.out.println("Сделан шаг ногой Sony");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
