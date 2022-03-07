package com.tms.task1;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;

public class Main {
    public static final String INPUT_FILE = "Lesson14/src/main/java/com/tms/task1/hw1/input.txt";
    public static final String OUTPUT_FILE = "Lesson14/src/main/java/com/tms/task1/hw1/output.txt";

    public static void main(String[] args) {
        /**
         * 1)В исходном файле hw1/input.txt находятся слова, каждое слово на новой строке.
         * После запуска программы должен создать файл output.txt, который будет содержать в себе только палиндромы.*/

        System.out.println(readPalindrome(INPUT_FILE));
        write(readPalindrome(INPUT_FILE), OUTPUT_FILE);
    }

    static String readPalindrome(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(StringUtils.reverse(line)) && !NumberUtils.isDigits(line)) {
                    stringBuilder.append(line + "\n");
                }
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void write(String text, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            if (!StringUtils.isEmpty(text))
                writer.write(text + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}



