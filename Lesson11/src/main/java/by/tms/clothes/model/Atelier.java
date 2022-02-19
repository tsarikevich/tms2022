package by.tms.clothes.model;


public class Atelier {
    private Tie tie;
    private Skirt skirt;
    private Tshirt tshirt;
    private Trousers trousers;
    private Clothes thing;//для вывода информации о размере


    public void dressMan(Clothes[] clothes) {
        for (Clothes thing : clothes) {
            this.thing = thing;
            if (thing instanceof Tie) {
                tie = (Tie) thing;
                tie.dressMan();
                System.out.println(tie + " " + this.thing.getSize().getDescription());
            } else if (thing instanceof Trousers) {
                trousers = (Trousers) thing;
                trousers.dressMan();
                System.out.println(trousers + " " + this.thing.getSize().getDescription());
            } else if (thing instanceof Tshirt) {
                tshirt = (Tshirt) thing;
                tshirt.dressMan();
                System.out.println(tshirt + " " + this.thing.getSize().getDescription());
            }
        }
    }

    public void dressWomen(Clothes[] clothes) {
        for (Clothes thing : clothes) {
            this.thing = thing;
            if (thing instanceof Skirt) {
                skirt = (Skirt) thing;
                skirt.dressWomen();
                System.out.println(skirt + " " + this.thing.getSize().getDescription());
            } else if (thing instanceof Trousers) {
                trousers = (Trousers) thing;
                trousers.dressWomen();
                System.out.println(trousers + " " + this.thing.getSize().getDescription());
            } else if (thing instanceof Tshirt) {
                tshirt = (Tshirt) thing;
                tshirt.dressWomen();
                System.out.println(tshirt + " " + this.thing.getSize().getDescription());
            }
        }

    }

}

