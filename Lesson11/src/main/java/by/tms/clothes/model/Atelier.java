package by.tms.clothes.model;


public class Atelier {


    public void dressMan(Clothes[] clothes) {
        for (Clothes thing : clothes) {
            if (thing instanceof MenClothes) {
                MenClothes menClothes = (MenClothes) thing;
                menClothes.dressMan();
                System.out.println(menClothes + " " + thing.getSize().getDescription());
            }
        }
    }

    public void dressWomen(Clothes[] clothes) {
        for (Clothes thing : clothes) {
            if (thing instanceof WomenClothes) {
                WomenClothes womenClothes = (WomenClothes) thing;
                womenClothes.dressWomen();
                System.out.println(womenClothes + " " + thing.getSize().getDescription());
            }
        }

    }

}

