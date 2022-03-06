package com.tms.task1;

import java.io.File;

/**
 * 1) Список каталога
 * Написать метод который циклически просматривает содержимое заданного каталога и выводит на печать информацию о всех файлах и каталогах, находящихся в нем и в его подкаталогах.
 * Используем рекурсию.
 * <p>
 * <p>
 * 3)Написать обобщенный класс MinMax, который содержит методы для нахождения минимального и максимального элемента массива.
 * Массив является переменной класса. Массив должен передаваться в класс через конструктор.
 * Написать метод принимающий MinMax объект и печатающий информацию об элементах.
 * <p>
 * 4)Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы - sum, multiply, divide,
 * subtraction. Параметры этих методов  - два числа разного типа, над которыми должна быть произведена операция.
 */
public class Main {
    public static void main(String[] args) {
        File directory = new File("D:\\Курсы JAVA");
        getInformation(directory);
    }

    public static void getInformation(File directory) {
        if (directory.isDirectory()) {
            System.out.println("----------------------------");
            System.out.println(directory.getParent() + "\\" + directory.getName() + ":");
            for (File item : directory.listFiles()) {
                if (item.isFile()) {
                    System.out.println(item.getName());
                }
                getInformation(item);
            }
        }
    }
}



