package by.tms.fruits;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple(4.897, 3.9);
        Apricot apricot = new Apricot(5.3242, 5.9);
        Pear pear = new Pear(3.324, 4.9);
        System.out.println("Стоимость всех проданных яблок - " + Apple.getCostAllApple());
        System.out.println("Стоимость всех проданных абрикосов - " + Apricot.getCostAllApricot());
        System.out.println("Стоимость всех проданных груш - " + Pear.getCostAllPear());
        System.out.println("Стоимость всех проданных фруктов - " + Fruit.getCostAllFruits());
        System.out.println(apple.getFruitCost());
        System.out.println(apple.getFruitCost());
        System.out.println("Стоимость всех проданных яблок - " + Apple.getCostAllApple());
        System.out.println("Стоимость всех проданных фруктов - " + Fruit.getCostAllFruits());
        System.out.println(apple.getFruitCost());
        System.out.println(apricot.getFruitCost());
        System.out.println(pear.getFruitCost());
        System.out.println(pear.getFruitCost());
        System.out.println("Стоимость всех проданных яблок - " + Apple.getCostAllApple());
        System.out.println("Стоимость всех проданных абрикосов - " + Apricot.getCostAllApricot());
        System.out.println("Стоимость всех проданных груш - " + Pear.getCostAllPear());
        System.out.println("Стоимость всех проданных фруктов - " + Fruit.getCostAllFruits());


    }
}
