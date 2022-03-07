package com.tms.task3;

/**
 * 3)Написать обобщенный класс MinMax, который содержит методы для нахождения минимального и максимального элемента массива.
 * Массив является переменной класса. Массив должен передаваться в класс через конструктор.
 * Написать метод принимающий MinMax объект и печатающий информацию об элементах.
 */
public class Main {
    public static void main(String[] args) {
        MinMax<Integer> minMax = new MinMax<>(new Integer[]{5, 2, 1, 4, 5});
        System.out.println("Минимальное значение - " + minMax.getMinValue());
        System.out.println("Максимальное значение - " + minMax.getMaxValue());
        printInformation(minMax);
    }

    static void printInformation(MinMax<?> obj) {
        for (int i = 0; i < obj.getMassive().length; i++) {
            System.out.println("Элемент массива [" + i + "] = " + obj.getMassive()[i]);
        }
    }
}
