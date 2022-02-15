package by.tms.robot.hands;

import lombok.ToString;

@ToString
public class SamsungHand implements IHand {
    private int price;

    public SamsungHand() {
    }

    public SamsungHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Поднята рука Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
