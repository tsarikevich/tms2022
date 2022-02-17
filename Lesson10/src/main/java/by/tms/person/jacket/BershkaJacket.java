package by.tms.person.jacket;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BershkaJacket implements Jacket {
    @Override
    public void putOn() {
        System.out.println("Курта Bershka надета");
    }

    @Override
    public void takeOff() {
        System.out.println("Курта Bershka снята");
    }
}
