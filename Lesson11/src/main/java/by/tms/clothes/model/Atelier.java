package by.tms.clothes.model;


public class Atelier {
    private Tie tie;
    private Skirt skirt;
    private Tshirt tshirt;
    private Trousers trousers;


    public void dressMan(Clothes[] clothes) {
        for (Clothes thing : clothes) {
            if (thing instanceof Tie) {
                tie = (Tie) thing;
                tie.dressMan();
            } else if (thing instanceof Trousers) {
                trousers = (Trousers) thing;
                trousers.dressMan();
            } else if (thing instanceof Tshirt) {
                tshirt = (Tshirt) thing;
                tshirt.dressMan();
            }
        }
    }


    public void dressWomen(Clothes[] clothes) {
        for (Clothes thing : clothes) {
            if (thing instanceof Skirt) {
                skirt = (Skirt) thing;
                skirt.dressWomen();
                System.out.println(skirt);
            } else if (thing instanceof Trousers) {
                trousers = (Trousers) thing;
                trousers.dressWomen();
            } else if (thing instanceof Tshirt) {
                tshirt = (Tshirt) thing;
                tshirt.dressWomen();
            }
        }

    }
}

