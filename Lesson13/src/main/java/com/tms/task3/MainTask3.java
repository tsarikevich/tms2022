package com.tms.task3;

import org.apache.commons.lang3.StringUtils;

public class MainTask3 {
    public static void main(String[] args) {
        /** 3) В массиве находятся слова. Вывести на экран слова палиндромы
         *(т.е которые читаются справа на лево и слева на право одинаково, например: заказ, казак, дед...)*/
        String[] words = {"доход", "машина", "репер", "карета", "довод"};
        for (String word : words) {
            if (word.equalsIgnoreCase(StringUtils.reverse(word))) {
                System.out.println(word);
            }
        }
    }
}



