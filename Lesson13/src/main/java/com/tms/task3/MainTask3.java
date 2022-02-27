package com.tms.task3;

public class MainTask3 {
    public static void main(String[] args) {
        /** 3) В массиве находятся слова. Вывести на экран слова палиндромы
         *(т.е которые читаются справа на лево и слева на право одинаково, например: заказ, казак, дед...)*/
        StringBuilder[] words = new StringBuilder[]{new StringBuilder("доход"), new StringBuilder("машина"), new StringBuilder("репер"), new StringBuilder("карета"), new StringBuilder("довод")};
        for (StringBuilder word : words) {
            StringBuilder tempWord = new StringBuilder(word).reverse();
            if (word.toString().equals(tempWord.toString())) {
                System.out.println(word);
            }
        }
    }
}



