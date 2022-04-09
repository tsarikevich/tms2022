package by.teachmeskills.task1.model;

import java.math.BigDecimal;


public class Calculator {

    public static <T extends Number, V extends Number> BigDecimal sum(T t, V v) {
        return new BigDecimal(String.valueOf(t)).add(new BigDecimal(String.valueOf(v)));
    }

    public static <T extends Number, V extends Number> BigDecimal multiply(T t, V v) {
        return new BigDecimal(String.valueOf(t)).multiply(new BigDecimal(String.valueOf(v)));
    }

    public static <T extends Number, V extends Number> BigDecimal divide(T t, V v) {
        return new BigDecimal(String.valueOf(t)).divide(new BigDecimal(String.valueOf(v)));
    }

    public static <T extends Number, V extends Number> BigDecimal subtraction(T t, V v) {
        return new BigDecimal(String.valueOf(t)).subtract(new BigDecimal(String.valueOf(v)));
    }


}
