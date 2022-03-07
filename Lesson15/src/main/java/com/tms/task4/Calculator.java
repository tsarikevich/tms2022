package com.tms.task4;

import java.math.BigDecimal;

/**
 * 4)Написать класс Калькулятор (необобщенный),
 * который содержит обобщенные статические методы - sum, multiply, divide,subtraction.
 * Параметры этих методов  - два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {

    static <T extends Number, V extends Number> BigDecimal sum(T t, V v) {
        return new BigDecimal(String.valueOf(t)).add(new BigDecimal(String.valueOf(v)));
    }

    static <T extends Number, V extends Number> BigDecimal multiply(T t, V v) {
        return new BigDecimal(String.valueOf(t)).multiply(new BigDecimal(String.valueOf(v)));
    }

    static <T extends Number, V extends Number> BigDecimal divide(T t, V v) {
        return new BigDecimal(String.valueOf(t)).divide(new BigDecimal(String.valueOf(v)));
    }

    static <T extends Number, V extends Number> BigDecimal subtraction(T t, V v) {
        return new BigDecimal(String.valueOf(t)).subtract(new BigDecimal(String.valueOf(v)));
    }


}
