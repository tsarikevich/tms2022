package by.tms.person.shoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ZaraShoes implements Shoes {
    @Override
    public void putOn() {
        System.out.println("Обувь Zara надета");
    }

    @Override
    public void takeOff() {
        System.out.println("Обувь Zara снята");
    }
}
