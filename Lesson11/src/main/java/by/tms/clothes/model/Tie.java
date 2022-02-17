package by.tms.clothes.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Tie extends Clothes implements MenClothes {
    @Override
    public void dressMan() {
        System.out.println("Галстук для мужчины");
    }
}
