package com.tms.task4;

/**
 * 4)Написать класс Калькулятор (необобщенный),
 * который содержит обобщенные статические методы - sum, multiply, divide,subtraction.
 * Параметры этих методов  - два числа разного типа, над которыми должна быть произведена операция.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(5.4, 3));
        System.out.println(Calculator.multiply(3.3, 2));
        System.out.println(Calculator.divide(3.3, 2));
        System.out.println(Calculator.subtraction(3.3, 2));
    }
}
