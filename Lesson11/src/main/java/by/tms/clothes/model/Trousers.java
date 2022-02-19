package by.tms.clothes.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Trousers extends Clothes implements MenClothes, WomenClothes {
    @Override
    public void dressMan() {
        System.out.println("Штаны для мужчины");
    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны для женщины");
    }
}
