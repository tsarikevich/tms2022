package by.tms.person.jacket;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ZaraJacket implements Jacket {

    @Override
    public void putOn() {
        System.out.println("Курта Zara надета");
    }

    @Override
    public void takeOff() {
        System.out.println("Курта Zara снята");
    }
}
