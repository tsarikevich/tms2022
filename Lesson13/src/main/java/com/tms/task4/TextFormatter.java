package com.tms.task4;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class TextFormatter {

    public void printSentence(String string) {
        if (!StringUtils.isEmpty(string)) {
            String[] sentences = string.split("\\.");
            for (String sentence : sentences) {
                if (3 <= getNumberWords(sentence) && getNumberWords(sentence) <= 5) {
                    System.out.println(sentence.trim());
                } else if (isPolidrome(sentence)) {
                    System.out.println(sentence.trim());
                }
            }
        } else {
            System.out.println("Вы ввели пустую строку или null");
        }
    }

    private Boolean isPolidrome(String string) {
        String[] words = string.trim().split(" ");
        for (String word : words) {
            if (NumberUtils.isDigits(word) || word.length() < 2) {
                continue;
            }
            if (word.equalsIgnoreCase(StringUtils.reverse(word))) {
                return true;
            }
        }
        return false;
    }

    private int getNumberWords(String string) {
        return string.trim().split(" ").length;
    }
}





