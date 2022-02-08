package com.tms.util;

import com.tms.model.Flower;
import lombok.ToString;

/**
 * Цветочный магазин.
 * Создать класс "Flower", который содержит переменные имя и стоимость, гет сет и toString (lombok подключаем)
 * Необходимо:
 * 1) собрать 5 букетов (используем массив) с определением их стоимости, т.е создаем класс Bouquet,
 * который содержит массив объектов Flower, который инициализируется через конструктор, а также метод по вычислению стоимости.
 * 2) вывести на консоль информацию по каждому букету.
 * 3*звездочка) Подсчитать количество всех проданных цветов.
 * Пояснения решения:
 * Создать класс FlowerMarket, который содержит метод public Bouquet getBouquet(String... flowers),
 * в классе Constants создать строковые константы названия цветов.
 * Для создания букета в метод getBouquet нужно передавать константы через запятую(ROSE, ROSE, ROSE, ROSE, ROSE)
 * По названию константы мы ищем стоимость цветка в 2-х мерном массиве
 * и преобразуем значение из строки в число, далее создаем через конструктор объект класса Flower и слаживаем в массив,
 * для передачи его в класс букета.
 * Заведомо в константах необходимо создать 2-х мерный массив типа String содержащий название цветка(константа) и его стоимость.
 * [ROSE] [15]
 * [LILY] [7]
 * [ASTER] [5]
 * [HERBERA] [5]
 * [TULIP] [8]
 * [CARNATION] [11]
 * Ps: если знаем другие конструкции, отличные от массива, то можно использовать.
 * <p>
 * <p>
 * Читатели библиотеки
 * Определить класс Reader, хранящий такую информацию о пользователе библиотеки:
 * ФИО,
 * номер читательского билета,
 * факультет,
 * дата рождения,
 * телефон.
 * Методы takeBook(), returnBook().
 * Разработать программу, в которой создается массив объектов данного класса.
 * Перегрузить методы takeBook(), returnBook():
 * - takeBook, который будет принимать количество взятых книг. Выводит на консоль сообщение "Петров В. В. взял 3 книги".
 * - takeBook, который будет принимать переменное количество названий книг.
 * Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
 * - takeBook, который будет принимать переменное количество объектов класса Book (создать новый класс, содержащий имя и автора книги).
 * Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
 * Аналогичным образом перегрузить метод returnBook(). Выводит на консоль сообщение "Петров В. В. вернул книги:
 * Приключения, Словарь, Энциклопедия". Или  "Петров В. В. вернул 3 книги"
 */
@ToString
public class Constants {
    private static Flower flower;
    public static final String ROSE = "роза";
    public static final String LILY = "лилия";
    public static final String ASTER = "астра";
    public static final String HERBERA = "гербера";
    public static final String TULIP = "тюльпан";
    public static final String CARNATION = "гвоздика";
    public static final String[] roseInformation = {ROSE, flower.getCost()};
    public static final String[] lilyInformation = {LILY, flower.getCost()};
    public static final String[] asterInformation = {ASTER, flower.getCost()};
    public static final String[] herberaInformation = {HERBERA, flower.getCost()};
    public static final String[] tulipInformation = {TULIP, flower.getCost()};
    public static final String[] carnationInformation = {CARNATION, flower.getCost()};
    public static String[][] allFlowers = {roseInformation, lilyInformation, asterInformation, herberaInformation, tulipInformation, carnationInformation};

}
