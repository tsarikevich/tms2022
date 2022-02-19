package by.tms.fruits;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Apricot extends Fruit {
    private static BigDecimal costAllApricot = BigDecimal.valueOf(0);

    public Apricot(double weight, double price) {
        setWeight(weight);
        setPrice(price);
    }

    @Override
    public BigDecimal getFruitCost() {
        BigDecimal apricotPrice = new BigDecimal(getPrice());
        BigDecimal apricotWeight = new BigDecimal(getWeight());
        printManufacturerInfo();
        System.out.print("абрикосы весом - " + getWeight() + ", стоят - ");
        BigDecimal oneApricotCost = (apricotPrice.multiply(apricotWeight)).setScale(5, RoundingMode.HALF_UP);
        costAllApricot = oneApricotCost.add(costAllApricot);
        return oneApricotCost;
    }


    public static BigDecimal getCostAllApricot() {
        return costAllApricot;
    }
}
