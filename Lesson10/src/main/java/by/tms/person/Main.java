package by.tms.person;

import by.tms.person.jacket.BershkaJacket;
import by.tms.person.jacket.NikeJacket;
import by.tms.person.jacket.ZaraJacket;
import by.tms.person.shoe.BershkaShoes;
import by.tms.person.shoe.NikeShoes;
import by.tms.person.shoe.ZaraShoes;
import by.tms.person.trouser.NikeTrousers;
import by.tms.person.trouser.ZaraTrousers;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иван", new NikeJacket(), new NikeShoes(), new NikeTrousers());
        Person person2 = new Person("Петр", new ZaraJacket(), new BershkaShoes(), new NikeTrousers());
        Person person3 = new Person("Илья", new BershkaJacket(), new ZaraShoes(), new ZaraTrousers());
        person1.putOn();
        person1.putOn();
        person1.takeOff();
        person1.takeOff();
        System.out.println("--------------------------------------");
        person2.putOn();
        person2.takeOff();
        System.out.println("--------------------------------------");
        person3.putOn();
        person3.takeOff();
    }
}
