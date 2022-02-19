package by.tms.fruits;


import java.math.BigDecimal;
import java.math.RoundingMode;


public class Apple extends Fruit {
    private static BigDecimal costAllApple = BigDecimal.ZERO;

    public Apple(double weight, double price) {
        super(weight, price);
    }

    @Override
    public BigDecimal getFruitCost() {
        printManufacturerInfo();
        System.out.print("яблоки весом - " + getWeight().setScale(5, RoundingMode.HALF_UP) + ", стоят - ");
        BigDecimal oneAppleCost = (getPrice().multiply(getWeight())).setScale(5, RoundingMode.HALF_UP);
        costAllApple = oneAppleCost.add(costAllApple);
        return oneAppleCost;
    }

    public static BigDecimal getCostAllApple() {
        return costAllApple;
    }
}
