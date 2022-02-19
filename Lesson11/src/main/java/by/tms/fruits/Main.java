package by.tms.fruits;


public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple(5.6, 4.730);
        Apricot apricot = new Apricot(3.7, 35.7);
        Pear pear = new Pear(7.3, 3.4);
        Fruit[] fruits = {apple, apple, apricot, pear, pear, pear};
        for (Fruit fruit : fruits) {
            System.out.println(fruit.getFruitCost());
        }
        System.out.println("Стоимость всех проданных яблок - " + Apple.getCostAllApple());
        System.out.println("Стоимость всех проданных груш - " + Pear.getCostAllPear());
        System.out.println("Стоимость всех проданных абрикосов - " + Apricot.getCostAllApricot());
        System.out.println("Стоимость всех проданных фруктов - " + Fruit.getCostAllFruits(fruits));
    }
}
