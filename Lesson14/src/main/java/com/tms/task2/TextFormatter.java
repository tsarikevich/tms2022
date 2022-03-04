package com.tms.task2;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;


public class TextFormatter {

    public ArrayList<String> sentencesForWrite(String string) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!StringUtils.isEmpty(string)) {
            String[] sentences = string.split("[.!?]");
            for (String sentence : sentences) {
                if (3 <= getNumberWords(sentence) && getNumberWords(sentence) <= 5) {
                    arrayList.add(sentence.trim());
                } else if (isPolidrome(sentence.trim())) {
                    arrayList.add(sentence);
                }
            }
        }
        return arrayList;
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





