package by.tms.person.shoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BershkaShoes implements Shoes {
    @Override
    public void putOn() {
        System.out.println("Обувь Bershka надета");
    }

    @Override
    public void takeOff() {
        System.out.println("Обувь Bershka снята");
    }
}
