package com.tms.task3;

import lombok.Getter;

/**
 * 3)Написать обобщенный класс MinMax, который содержит методы для нахождения минимального и максимального элемента массива.
 * Массив является переменной класса. Массив должен передаваться в класс через конструктор.
 * Написать метод принимающий MinMax объект и печатающий информацию об элементах.
 */
@Getter
public class MinMax<T extends Number & Comparable<? super T>> {
    private T[] massive;

    public MinMax(T[] massive) throws IllegalArgumentException {
        if (massive == null || massive.length == 0) {
            throw new IllegalArgumentException("massive can not be empty or null");
        } else {
            this.massive = massive;
        }
    }

    public T getMinValue() {
        T min = massive[0];
        for (int i = 1; i < massive.length; i++) {
            if (min.compareTo(massive[i]) > 0) {
                min = massive[i];
            }
        }
        return min;
    }


    public T getMaxValue() {
        T max = massive[0];
        for (int i = 1; i < massive.length; i++) {
            if (max.compareTo(massive[i]) < 0) {
                max = massive[i];
            }
        }
        return max;
    }
}
