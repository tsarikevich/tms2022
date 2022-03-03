package com.tms.task1;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;


/**
 * <p>
 * 3) Проверка на цензуру:
 * Создаете 2 файла.
 * 1 - й. Содержит исходный текст.
 * 2 - й. Содержит слова недопустимые в тексте (black list). Структура файла определите сами, хотите каждое слово на новой строке, хотите через запятую разделяйте.
 * Задача: необходимо проверить проходит ли текст цензуру. Если в тексте не встретилось ни одного недопустимого слова, то выводите сообщение о том что текст прошел проверку на цензуру.
 * Если нет, то выводите соответствующее сообщение, кол-во предложений не прошедших проверку и сами предложения подлежащие исправлению.
 * 4) Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров), бак(тип топлива, объем), скорость, цена). Количество цилиндров не должно сереализоватся в файл(это конфедициальная информация)
 * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль
 * 5) Задача со *
 * Скопировать объект Car из пакета hw5, добавить библиотеки
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.12.3
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.12.3
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/2.12.3
 * через maven в проект. Далее вычитать данные в json формате из файла (hw5/car.json), руками файл изменять нельзя!
 * Преобразовать прочитанные данные в объект hw5.Car (название полей редактировать нельзя, добавлять поля также нельзя) и вывести на консоль объект через System.out.println();
 */

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



