package com.tms.task2;

import java.io.*;
import java.util.ArrayList;

public class Main {
    /**
     * 2)Текстовый файл hw2/input.txt содержит текст.
     * После запуска программы в другой файл должны записаться только те предложения, в которых от 3-х до 5-ти слов.
     * Если в предложении присутствует слово-палиндром, то не имеет значения какое кол-во слов в предложении, оно попадает в output.txt файл.
     * Пишем все в ООП стиле. Создаем класс com.tms.task2.TextFormatter
     * в котором два метода:
     * 1. Метод принимает строку и возвращает кол-во слов в строке.
     * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
     * В main считываем файл.
     * Разбиваем текст на предложения. Используя методы класса com.tms.task2.TextFormatter определяем подходит ли нам предложение.
     * Если подходит добавляем его в output.txt файл
     */

    public static final String INPUT_FILE = "Lesson14/src/main/java/com/tms/task2/hw2/input.txt";
    public static final String OUTPUT_FILE = "Lesson14/src/main/java/com/tms/task2/hw2/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            String line;
            TextFormatter textFormatter = new TextFormatter();
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println(stringBuilder.toString());
            ArrayList<String> sentence = textFormatter.sentencesForWrite(stringBuilder.toString());
            for (String s : sentence) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

