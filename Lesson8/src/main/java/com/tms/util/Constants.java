package com.tms.util;

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
 */

public class Constants {
    public static final String ROSE = "роза";
    public static final String LILY = "лилия";
    public static final String ASTER = "астра";
    public static final String HERBERA = "гербера";
    public static final String TULIP = "тюльпан";
    public static final String CARNATION = "гвоздика";
    public static final String[] roseInformation = {ROSE, "15"};
    public static final String[] lilyInformation = {LILY, "7"};
    public static final String[] asterInformation = {ASTER, "5"};
    public static final String[] herberaInformation = {HERBERA, "5"};
    public static final String[] tulipInformation = {TULIP, "8"};
    public static final String[] carnationInformation = {CARNATION, "11"};
    public static String[][] allFlowers = {roseInformation, lilyInformation, asterInformation, herberaInformation, tulipInformation, carnationInformation};

}
