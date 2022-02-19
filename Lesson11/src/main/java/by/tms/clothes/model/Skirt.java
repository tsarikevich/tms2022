package by.tms.clothes.model;


import lombok.experimental.SuperBuilder;

@SuperBuilder

public class Skirt extends Clothes implements WomenClothes {
    @Override
    public void dressWomen() {
        System.out.println("Юбка для женщины");
    }


}

