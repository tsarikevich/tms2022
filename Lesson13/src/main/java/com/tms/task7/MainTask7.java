package com.tms.task7;

/**
 * 7*(Можно не делать!))Найти количество слов, содержащих только символы латинского алфавита. Пример:
 * "Методы доступа называют ещё аксессорами (от англ. access — доступ), или по отдельности — геттерами (англ. get — чтение) and сеттерами (англ. set — запись)"
 */
public class MainTask7 {
    public static void main(String[] args) {
        String string = "Методы доступа называют ещё аксессорами " +
                "(от англ. access — доступ), или по отдельности — " +
                "геттерами (англ. get — чтение) " +
                "and сеттерами (англ. set — запись)";
        String[] words = string.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.matches("^[a-zA-Z()]+$")) {
                count++;
            }
        }
        System.out.println("Количество слов, содержащих только символы латинского алфавита - " + count);
    }
}

