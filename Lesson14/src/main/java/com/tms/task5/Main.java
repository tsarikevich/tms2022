package com.tms.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.task5.hw5.Car;

import java.io.File;
import java.io.IOException;

/**
 * 5) Задача со *
 * Скопировать объект Car из пакета hw5, добавить библиотеки
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.12.3
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.12.3
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/2.12.3
 * через maven в проект. Далее вычитать данные в json формате из файла (hw5/car.json), руками файл изменять нельзя!
 * Преобразовать прочитанные данные в объект hw5.Car (название полей редактировать нельзя, добавлять поля также нельзя) и вывести на консоль объект через System.out.println();
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(new File("Lesson14/src/main/java/com/tms/task5/hw5/car.json"), Car.class);
        System.out.println(car);
    }
}
