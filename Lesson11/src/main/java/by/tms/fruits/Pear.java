package by.tms.fruits;


import java.math.BigDecimal;
import java.math.RoundingMode;


public class Pear extends Fruit {
    private static BigDecimal costAllPear = BigDecimal.ZERO;

    public Pear(double weight, double price) {
        super(weight, price);
    }

    @Override
    public BigDecimal getFruitCost() {
        printManufacturerInfo();
        System.out.print("груши весом - " + getWeight().setScale(5, RoundingMode.HALF_UP) + ", стоят - ");
        BigDecimal onePearCost = (getPrice().multiply(getWeight())).setScale(5, RoundingMode.HALF_UP);
        costAllPear = costAllPear.add(onePearCost);
        return onePearCost;
    }

    public static BigDecimal getCostAllPear() {
        return costAllPear;
    }
}



