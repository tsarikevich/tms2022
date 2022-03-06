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

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(StringUtils.reverse(line)) && !NumberUtils.isDigits(line)) {
                    System.out.println(line);// для проверки
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



