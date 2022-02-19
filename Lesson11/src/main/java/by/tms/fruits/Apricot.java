package by.tms.fruits;


import java.math.BigDecimal;
import java.math.RoundingMode;


public class Apricot extends Fruit {
    private static BigDecimal costAllApricot = BigDecimal.ZERO;

    public Apricot(double weight, double price) {
        super(weight, price);
    }

    @Override
    public BigDecimal getFruitCost() {
        printManufacturerInfo();
        System.out.print("абрикосы весом - " + getWeight().setScale(5, RoundingMode.HALF_UP) + ", стоят - ");
        BigDecimal oneApricotCost = (getPrice().multiply(getWeight())).setScale(5, RoundingMode.HALF_UP);
        costAllApricot = oneApricotCost.add(costAllApricot);
        return oneApricotCost;
    }
    public static BigDecimal getCostAllApricot() {
        return costAllApricot;
    }
}
