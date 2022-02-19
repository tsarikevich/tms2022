package by.tms.fruits;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Apple extends Fruit {
    private static BigDecimal costAllApple = BigDecimal.valueOf(0);

    public Apple(double weight, double price) {
        setWeight(weight);
        setPrice(price);
    }

    @Override
    public BigDecimal getFruitCost() {
        BigDecimal applePrice = new BigDecimal(getPrice());
        BigDecimal appleWeight = new BigDecimal(getWeight());
        printManufacturerInfo();
        System.out.print("яблоки весом - " + getWeight() + ", стоят - ");
        BigDecimal oneAppleCost = (applePrice.multiply(appleWeight)).setScale(5, RoundingMode.HALF_UP);
        costAllApple = oneAppleCost.add(costAllApple);
        return oneAppleCost;
    }


    public static BigDecimal getCostAllApple() {
        return costAllApple;
    }


}
