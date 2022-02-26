package com.tms.task4;

import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;

@Getter
public class TextFormatter {
    private ArrayList<StringBuilder> sentences;
    private ArrayList<StringBuilder> words;


//    public int getCountWords(String string) {
//        if (string.isEmpty()) {
//            return 0;
//        } else {
//            return getWords(string).size();
//        }
//    }

//    public void printSentencesWithPalindrome() {
//        sentences=getSentences();
//        for (StringBuilder sentence : sentences) {
//
//            if (isWordsPalindromeInSentence() || getWords().size() > 3) {
//                System.out.println(sentence);
//            }
//        }
//    }

    public Boolean isWordsPalindromeInSentence(String string) {
        if (string.isEmpty()) {
            return false;
        } else {
            sentences = getSentencesFromText(string);
            for (StringBuilder sentence : sentences) {
                for (StringBuilder word : getWords(sentences)) {
                    if (sentence.length() > 1 && !NumberUtils.isDigits(String.valueOf(sentence))) {
                        StringBuilder tempWord = new StringBuilder(sentence).reverse();
                        if (sentence.toString().equals(tempWord.toString())) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }


    private ArrayList<StringBuilder> getSentencesFromText(String string) {
        this.sentences = new ArrayList<>();
        String[] sentences = string.split("\\.");
        for (String s : sentences) {
            this.sentences.add(new StringBuilder(s));
        }
        return this.sentences;
    }

    private ArrayList<StringBuilder> getWords(ArrayList<StringBuilder> sentences) {
        words = new ArrayList<>();
        for (StringBuilder s : sentences) {
            String[] wordsString = s.toString().split(" ");
            for (String s1 : wordsString) {
                if (!(s1 == "")) {
                    words.add(new StringBuilder(s1));
                }
            }
        }
        return words;
    }

}





