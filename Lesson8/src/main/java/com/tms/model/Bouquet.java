package com.tms.model;

import java.util.Arrays;

/**
 * Цветочный магазин.
 * Создать класс "Flower", который содержит переменные имя и стоимость, гет сет и toString
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
 */


public class Bouquet {
    private Flower[] flowers;


    public Bouquet(Flower[] flowers) {
        this.flowers = flowers;
    }

    public int getCostBouquet() {
        int resultCost = 0;
        for (Flower flower : flowers) {
            int oneCost = Integer.parseInt(flower.getCost());
            resultCost += oneCost;
        }
        return resultCost;
    }

    @Override
    public String toString() {
        return "Букет из цветов: " + Arrays.toString(flowers) +
                "\nСТОИМОСТЬ БУКЕТА - " + getCostBouquet() + " руб.";
    }
}


