package com.tms.task5;

/**
 * 5)Даны строки разной длины (длина - четное число), необходимо вернуть ее два средних знака:
 * Пример: "string" → "ri", "code" → "od", "Practice"→"ct".
 */
public class MainTask5 {
    public static void main(String[] args) {
        String string = "String";
        System.out.println(string.substring(string.length() / 2 - 1, string.length() / 2 + 1));

    }
}
