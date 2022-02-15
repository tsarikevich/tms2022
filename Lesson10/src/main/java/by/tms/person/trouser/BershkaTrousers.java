package by.tms.person.trouser;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BershkaTrousers implements Trousers {
    @Override
    public void putOn() {
        System.out.println("Штаны Bershka надеты");
    }

    @Override
    public void takeOff() {
        System.out.println("Штаны Bershka сняты");
    }
}
