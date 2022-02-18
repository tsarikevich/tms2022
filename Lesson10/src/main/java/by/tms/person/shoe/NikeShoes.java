package by.tms.person.shoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NikeShoes implements Shoes {
    @Override
    public void putOn() {
        System.out.println("Обувь Nike надета");
    }

    @Override
    public void takeOff() {
        System.out.println("Обувь Nike снята");
    }
}
