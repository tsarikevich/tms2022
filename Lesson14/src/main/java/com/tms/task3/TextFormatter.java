package com.tms.task3;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFormatter {
    StringBuilder getText(String text) {
        String line;
        StringBuilder stringBuilderText = new StringBuilder();
        try (BufferedReader bufferedReaderText = new BufferedReader(new FileReader(text))) {
            while ((line = bufferedReaderText.readLine()) != null) {
                stringBuilderText.append(StringUtils.stripStart(line, StringUtils.SPACE) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilderText;
    }

    ArrayList<String> getWrongSentences(String[] sentences, String[] words) {
        ArrayList<String> wrongSentences = new ArrayList<>();
        for (String sentence : sentences) {
            for (String word : words) {
                if (StringUtils.contains(sentence, word) && !StringUtils.isEmpty(word)) {
                    wrongSentences.add(StringUtils.stripStart(sentence, StringUtils.SPACE));
                }
            }
        }
        return wrongSentences;
    }
}

