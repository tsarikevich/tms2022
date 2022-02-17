package by.tms.person.jacket;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NikeJacket implements Jacket {
    @Override
    public void putOn() {
        System.out.println("Курта Nike надета");
    }

    @Override
    public void takeOff() {
        System.out.println("Курта Nike снята");
    }
}
