package by.tms.person.trouser;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ZaraTrousers implements Trousers {
    @Override
    public void putOn() {
        System.out.println("Штаны Zara надеты");
    }

    @Override
    public void takeOff() {
        System.out.println("Штаны Zara сняты");
    }
}
