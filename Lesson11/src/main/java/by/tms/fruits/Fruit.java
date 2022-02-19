package by.tms.fruits;
/**
 * Задача4
 * Создать абстрактный класс Фрукт и классы Яблоко, Груша, Абрикос расширяющие его.
 * Класс Фрукт содержит:
 * а) переменную вес,
 * б) метод printManufacturerInfo(){System.out.print("Made in Belarus");} который нельзя изменить в наследнике.
 * в) абстрактный метод, возвращающий стоимость фрукта, который должен быть переопределен в каждом классе наследнике.
 * Метод должен учитывать вес фрукта(Т.е в зависимости от веса разная цена)
 * Создать несколько объектов разных классов.
 * Подсчитать общую стоимость проданных фруктов.
 * А также общую стоимость отдельно проданных яблок, груш и абрикос.
 */

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Getter
public abstract class Fruit {
    private BigDecimal weight;
    private BigDecimal price;
    private static BigDecimal costAll = BigDecimal.ZERO;

    public Fruit(double weight, double price) {
        this.weight = new BigDecimal(weight);
        this.price = new BigDecimal(price);
    }


    public final void printManufacturerInfo() {
        System.out.print("Made in Belarus ");
    }

    public abstract BigDecimal getFruitCost();

    public static BigDecimal getCostAllFruits(Fruit[] fruits) {
        for (Fruit fruit : fruits) {
            costAll = (costAll.add((fruit.getPrice().multiply(fruit.getWeight())))).setScale(5, RoundingMode.HALF_UP);
        }
        return costAll;

    }
}
