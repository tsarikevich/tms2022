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
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Задача5*(звездочка)
 * Используя перечисления(enum), реализовать программу по вычислению площади фигуры (метод getSquare).
 * Создать классы Фигура, Линия, Треугольник, Прямоугольник. Можно пользоваться интерфейсами, при необходимости!
 * Если у фигуры нельзя вычислить площадь, то метод не должен быть реализован в в этом классе.
 * Добавить фигуры в массив, пробежать по массиву и вызвать метод getSquare.
 * Внимание!!! пользоваться instanceof НЕЛЬЗЯ, тут нужно применить перечисления.
 */
@Setter
@Getter
public abstract class Fruit {
    private double weight;
    private double price;


    public final void printManufacturerInfo() {
        System.out.print("Made in Belarus ");
    }

    public abstract BigDecimal getFruitCost();

    public final static BigDecimal getCostAllFruits() {
        return Apple.getCostAllApple().add(Apricot.getCostAllApricot()).add(Pear.getCostAllPear());

    }
}
