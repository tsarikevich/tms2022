package com.tms.task2;

/**
 * 2) Обобщенный класс с тремя параметрами
 * Создать обобщенный класс с тремя параметрами (T, V, K).
 * Класс содержит три переменные типа (T, V, K), конструктор, принимающий на вход параметры типа (T, V, K),
 * методы возвращающие значения трех переменных. Создать метод, выводящий на консоль имена классов для трех переменных класса.
 * Наложить ограничения на параметры типа: T должен реализовать интерфейс Comparable (String),
 * V должен реализовать интерфейс Serializable и расширять класс Animal, K должен расширять класс Number.
 **/
public class Main {
    public static void main(String[] args) {
        GenericClass<String, Dog, Integer> genericClass = new GenericClass<>("Привет", new Dog("Шарик"), 5);
        genericClass.showClasses();
        System.out.println("Животное зовут - " + genericClass.getV().getName() + ", оно умеет говорить - " + genericClass.getV().say());
    }

}
