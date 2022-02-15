package by.tms.person;

import by.tms.person.jacket.Jacket;
import by.tms.person.shoe.Shoes;
import by.tms.person.trouser.Trousers;

public class Person {
    private String name;
    private Jacket jacket;
    private Shoes shoes;
    private Trousers trousers;
    private boolean isPutOn;

    public Person(String name, Jacket jacket, Shoes shoes, Trousers trousers) {
        this.name = name;
        this.jacket = jacket;
        this.shoes = shoes;
        this.trousers = trousers;
    }

    void putOn() {
        if (!isPutOn) {
            jacket.putOn();
            trousers.putOn();
            shoes.putOn();
            isPutOn = true;
        } else {
            System.out.println(name + " уже одет(-а)");
        }
    }

    void takeOff() {
        if (isPutOn) {
            jacket.takeOff();
            trousers.takeOff();
            shoes.takeOff();
            isPutOn = false;
        } else {
            System.out.println(name + " уже раздет(-а)");
        }
    }
}
