package by.tms.instrument;

import java.util.Scanner;


public interface Instrumental {
    /**
     * Задача1:
     * Интерфейс Инструмент
     * <p>
     * 1) Создать интерфейс Инструмент(внутри enum Type с перечислением типов инструментов) и реализующие его классы Гитара, Барабан и Труба.
     * 2) Интерфейс Инструмент содержит метод play() и переменную String KEY ="До мажор".
     * 3) Гитара содержит переменные класса количествоСтрун,  Барабан - размер, Труба - диаметр.
     * 4) Создать массив типа Инструмент, содержащий инструменты разного типа.
     * 5) Наполнять массив инструментами необходимо через метод createInstrument,
     * который на вход принимает Тип инструмента(enum) и создает конкретный инструмент.
     * 6) В цикле вызвать метод play() для каждого инструмента, который должен выводить строку
     * "Играет такой-то инструмент, с такими-то характеристиками".
     */
    String KEY = "До мажор";

    void play();

    enum Type {
        GUITAR, DRUM, TRUMPET;
        private static Scanner scanner = new Scanner(System.in);

        static Instrumental createInstrument(Type instrument) {
            if (Type.GUITAR.equals(instrument)) {
                System.out.println("Введите количество струн гитары");
                Guitar guitar = new Guitar(scanner.nextInt());
                guitar.play();
                return guitar;
            } else if (Type.DRUM.equals(instrument)) {
                System.out.println("Введите размер барабана");
                Drum drum = new Drum(scanner.nextInt());
                drum.play();
                return drum;
            } else if (Type.TRUMPET.equals(instrument)) {
                System.out.println("Введите диаметр трубы");
                Trumpet trumpet = new Trumpet(scanner.nextInt());
                trumpet.play();
                return trumpet;
            }
            return null;
        }
    }
}

