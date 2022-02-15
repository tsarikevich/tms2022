package by.tms.person.trouser;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NikeTrousers implements Trousers {
    @Override
    public void putOn() {
        System.out.println("Штаны Nike надеты");
    }

    @Override
    public void takeOff() {
        System.out.println("Штаны Nike сняты");
    }
}
