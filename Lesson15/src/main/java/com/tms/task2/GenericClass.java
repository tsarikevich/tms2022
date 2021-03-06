package com.tms.task2;

import lombok.Getter;

import java.io.Serializable;

/**
 * 2) Обобщенный класс с тремя параметрами
 * Создать обобщенный класс с тремя параметрами (T, V, K).
 * Класс содержит три переменные типа (T, V, K), конструктор, принимающий на вход параметры типа (T, V, K),
 * методы возвращающие значения трех переменных. Создать метод, выводящий на консоль имена классов для трех переменных класса.
 * Наложить ограничения на параметры типа: T должен реализовать интерфейс Comparable (String),
 * V должен реализовать интерфейс Serializable и расширять класс Animal, K должен расширять класс Number.
 **/
@Getter
public class GenericClass<T extends Comparable<String>, V extends Animal & Serializable, K extends Number> {
    private T t;
    private V v;
    private K k;


    public GenericClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }


    public void showClasses() {
        System.out.println("Имя класса T: " + t.getClass().getName());
        System.out.println("Имя класса V: " + v.getClass().getName());
        System.out.println("Имя класса K: " + k.getClass().getName());
    }
}
