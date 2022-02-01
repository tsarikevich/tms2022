package by.tms.model;

import java.util.Random;
import java.util.Scanner;

/**
 * в папке src/main/java создать пакет by.tms.model
 * в пакете создать класс Computer
 * 1) класс Computer будет содержать следующие поля:
 * - процессор
 * - оперативка
 * - жесткий диск
 * - ресурс полных циклов работы (включился выключился это один цикл)
 * <p>
 * 2) класс Computer будет содержать следующие методы:
 * - метод описание(вывод всех полей)
 * - метод включить (on())
 * - при включении может произойти сбой, поэтому при вызове метода on() необходимо написать следующую логику:
 * на консоль вывести сообщение (Внимание! Введите 0 или 1)
 * создать экземпляр класса Random, который будет генерировать число 0 или 1.
 * если введенное вами число совпадет с рандомным, то компьютер выключается.
 * если введенное вами число не совпадет с рандомным, то компьютер сгорает.
 * - при повторном включении компьютера, если он сгорел необходимо выдать сообщение "Компьютер сгорел!"
 * - выключить (off()) Проверяем если компьютер не сгорел то пишем "Выключение компьютера" и уменьшаем счетчик
 * ресурса полных циклов работы
 * - при превышении лимита ресурса комп сгорает. Пишем сообщение "Компьютер сгорел!"
 */
public class Computer {
    private String processor;
    private int ram;
    private int hdd;
    private int circle;
    private int userEnter;
    private int randomComputer;
    private boolean isComputerBurned = false;

    public Computer(String processor, int ram, int hdd, int circle) {
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.circle = circle;
    }

    public void computerInformation() {
        System.out.println("Процессор компьютера - " + processor);
        System.out.println("Оперативная память - " + ram + " Gb");
        System.out.println("Жесткий диск - " + hdd + " Gb");
        System.out.println("Количество циклов включения/выключения компьютера - " + circle);
    }

    public void on() {
        Scanner scanner = new Scanner(System.in);
        if (this.circle != 0 && !isComputerBurned) {
            System.out.println("Внимание! Введите 0 или 1");
            this.userEnter = scanner.nextInt();
            Random random = new Random();
            this.randomComputer = random.nextInt(2);
            System.out.println("Значение числа в компьютере = " + this.randomComputer);
            if (this.userEnter == this.randomComputer) {
                System.out.println("Компьютер включен");
            } else {
                System.out.println("Компьютер сгорел");
                this.isComputerBurned = true;
            }
        } else {
            System.out.println("Компьютер сгорел");
            this.isComputerBurned = true;
        }

    }

    public void off() {
        if (this.circle != 0 && !isComputerBurned) {
            if (this.userEnter != this.randomComputer) {
                System.out.println("Компьютер сгорел, выключать не нужно");
            } else {
                System.out.println("Компьютер выключен");
                this.circle = this.circle - 1;
            }
        }
    }
}
