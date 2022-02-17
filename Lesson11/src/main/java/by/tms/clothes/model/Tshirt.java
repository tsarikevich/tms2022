package by.tms.clothes.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Tshirt extends Clothes implements MenClothes, WomenClothes {
    @Override
    public void dressMan() {
        System.out.println("Футболка для мужчины");
    }

    @Override
    public void dressWomen() {
        System.out.println("Футболка для женщины");
    }
}
