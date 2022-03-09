package com.tms.task3;

/**
 * 3)Написать обобщенный класс MinMax, который содержит методы для нахождения минимального и максимального элемента массива.
 * Массив является переменной класса. Массив должен передаваться в класс через конструктор.
 * Написать метод принимающий MinMax объект и печатающий информацию об элементах.
 */
public class Main {
    public static void main(String[] args) {
        MinMax<Integer> minMax = null;
        try {
            minMax = new MinMax<>(new Integer[]{});
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        printInformation(minMax);
    }

    static void printInformation(MinMax<?> obj) {
        if (obj.getMassive().length != 0) {
            if (obj.getMinValue().doubleValue() == obj.getMaxValue().doubleValue()) {
                System.out.println("Минимальное и максимальное значения равны " + obj.getMinValue());
            } else {
                System.out.println("Минимальное значение - " + obj.getMinValue());
                System.out.println("Максиммальное значение - " + obj.getMaxValue());
            }
            for (int i = 0; i < obj.getMassive().length; i++) {
                System.out.println("Элемент массива [" + i + "] = " + obj.getMassive()[i]);
            }
        } else {
            System.out.println("Передан пустой массив");
        }
    }
}
