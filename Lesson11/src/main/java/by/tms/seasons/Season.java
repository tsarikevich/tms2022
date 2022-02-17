package by.tms.seasons;

import lombok.ToString;

/**
 * Задача2: Времена года
 * <p>
 * 1) Создать перечисление, содержащее названия времен года.
 * 2) Создать переменную содержащую ваше любимое время года и распечатать всю информацию о нем.
 * 3) Создать метод, который принимает на вход переменную созданного вами enum типа.
 * Если значение равно Лето, выводим на консоль “Я люблю лето” и так далее. Используем оператор switch.
 * 4) Перечисление должно содержать переменную, содержащую среднюю температуру в каждом времени года.
 * 5) Добавить конструктор принимающий на вход среднюю температуру.
 * 6) Создать метод getDescription, возвращающий строку “Холодное время года”.
 * Переопределить метод getDescription - для константы Лето метод должен возвращать “Теплое время года”.
 * 7) В цикле распечатать все времена года, среднюю температуру и описание времени года.
 */
@ToString
public enum Season {
    WINTER(-5), SPRING(10), SUMMER(22) {
        @Override
        String getDescription() {
            return "Теплое время года";
        }
    }, AUTUMN(15);
    private int averageTemperature;

    Season(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public static void getFavourite(Season favouriteSeason) {

        switch (favouriteSeason) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
            default:
                System.out.println("Что-то пошло не так");
        }
    }

    String getDescription() {
        return "Холодное время года";
    }

    static void getAllSeasons() {
        for (Season season : values()) {
            System.out.println(season);
        }
    }
}
