package by.tms.service;

import by.tms.model.Computer;

/**
 * 3) создать пакет by.tms.service
 * создать класс Main создать метод main
 * создать экземпляр класса Computer или реальный объект, через конструктор передать значение полей класса,
 * т.е необходимо сгенерировать конструктор с полями класса перечисленными в 1 пункте
 * Далее у объекта Computer вызвать его методы, в которых будет реализована логика по включению, выключению
 * и выводу информации про него.
 */
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("AMD RYZEN 5600", 16, 512, 4);
        computer.computerInformation();
        computer.on();
        computer.off();
        computer.on();
        computer.off();
        computer.on();
        computer.off();
        computer.on();
        computer.off();
        computer.on();
        computer.off();
    }
}
