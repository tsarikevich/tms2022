package by.tms.fruits;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Pear extends Fruit {
    private static BigDecimal costAllPear = BigDecimal.valueOf(0);

    public Pear(double weight, double price) {
        setWeight(weight);
        setPrice(price);
    }

    @Override
    public BigDecimal getFruitCost() {
        BigDecimal pearPrice = new BigDecimal(getPrice());
        BigDecimal pearWeight = new BigDecimal(getWeight());
        printManufacturerInfo();
        System.out.print("груши весом - " + getWeight() + ", стоят - ");
        BigDecimal onePearCost = (pearPrice.multiply(pearWeight)).setScale(5, RoundingMode.HALF_UP);
        costAllPear = onePearCost.add(costAllPear);
        return onePearCost;
    }

    public static BigDecimal getCostAllPear() {
        return costAllPear;
    }
}
