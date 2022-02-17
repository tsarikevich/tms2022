package by.tms.robot.heads;

import lombok.ToString;

@ToString
public class SamsungHead implements IHead {
    private int price;

    public SamsungHead(int price) {
        this.price = price;
    }

    public SamsungHead() {
    }

    @Override
    public void speak() {
        System.out.println("Говорит голова Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
