package by.tms.task2;

import java.util.Scanner;

//2) задача!
    /*
 Напишите структуру классов и продемонстрируйте работу
 - Машина имеет двигатель, бензобак (реализуйте класс для каждой сущности).
 - Чтобы поехать, машину необходимо завести, т.е. включить двигатель.
 - Реализуйте методы включения машины, который в свою очередь включает её двигатель.
 - Реализуйте метод езды на машине (например просто печатаем на консоль, что машина поехала)
 - Если машина не заведена, ехать она не может.
 - Машину можно заглушить.
 - После каждой поездки считаем, что машина прошла фиксированное расстояние.
 - Реализовать возможность посмотреть, какое расстояние машина прошла за все время.
 - Чтобы создать машину обязательно нужно иметь двигатель и бензобак.
 - Марка машины, год выпуска, пройденное расстояние - не обязательны при создании машины и могут быть выставлены потом.
 (не обязательно задавать в конструкторе)
 - После создания поменять двигатель машине нельзя.
 - Чтобы машина завелась, у неё должно быть топливо в бензобаке, если топлива нет, машина не может завестись.
 - Машину можно дозаправить, можно проверить сколько топлива осталось.
 - Реализуйте пару полей для двигателя и бензобака, например: тип двигателя, общий объем бензобака,
 сколько бензина сейчас и т.д.
     */
public class Car {
    private boolean isCarOn;
    private int distance;
    private final Engine ENGINE;
    private GasTank gasTank;
    private Scanner scanner = new Scanner(System.in);


    public Car(String engine, int gasTank) {
        this.ENGINE = new Engine(engine);
        this.gasTank = new GasTank(gasTank);
    }

    public void on() {
        if (gasTank.getGasTank() == 0) {
            System.out.println("Машину нужно заправить. Введите 1, если хотите заправиться сейчас, любую другую цифру - заправить потом:");
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println("Введите количество литров для заправки:");
                int litres = scanner.nextInt();
                gasTank.setGasTank(litres + gasTank.getGasTank());
                System.out.println("Количество литров в баке сейчас - " + gasTank.getGasTank());
                on();
            } else {
                System.out.println("Вы решили заправиться в следующий раз");
            }
        } else if (!isCarOn) {
            ENGINE.on();
            System.out.println("Машина заведена");
            isCarOn = true;
        } else {
            System.out.println("Машина уже заведена, защита от повторного включения");
        }
    }

    public void off() {
        if (isCarOn) {
            System.out.println("Машина заглушена");
            isCarOn = false;
        } else {
            System.out.println("Машину нужно завести");
        }
        countDistance();

    }

    public void countDistance() {
        System.out.println("Пройденное расстояние машиной - " + distance);
    }

    public void refuelCar() {
        System.out.println("Введите сколько литров вы хотите заправить");
        int refuel = scanner.nextInt();
        gasTank.setGasTank(refuel + gasTank.getGasTank());
        System.out.println("Топлива в бензобаке - " + gasTank.getGasTank());
    }

    public void carStarting() {
        if (isCarOn) {
            System.out.println("Машина поехала");
            distance += 100;
        } else {
            System.out.println("Машину нужно завести");
        }
    }

    private class Engine {
        private final String typeOfEngine;

        public Engine() {
            typeOfEngine = null;
        }

        public Engine(String typeOfEngine) {
            this.typeOfEngine = typeOfEngine;
        }

        void on() {
            System.out.println("Двигатель включен");
        }
    }

    private class GasTank {
        private int gasTank;// количество литров бензина
        private int gasTankCapacity; //объем бензобака

        public GasTank(int gasTank, int gasTankCapacity) {
            this.gasTank = gasTank;
            this.gasTankCapacity = gasTankCapacity;
        }

        public GasTank(int gasTank) {
            this.gasTank = gasTank;
        }

        public int getGasTank() {
            return gasTank;
        }

        public void setGasTank(int gasTank) {
            this.gasTank = gasTank;

        }


    }
}
