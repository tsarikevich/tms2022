package com.tms.task4;

import java.io.*;

/**
 * 4) Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров), бак(тип топлива, объем), скорость, цена). Количество цилиндров не должно сереализоватся в файл(это конфедициальная информация)
 * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль
 */
public class Main {
    public static String fileCars = "Lesson14/src/main/java/com/tms/task4/cars.txt";

    public static void main(String[] args) {
        Car car1 = new Car("AUDI", "TDI", 6, "DIESEL", 60, 220.0, 40000.0);
        Car car2 = new Car("TOYOTA", "Atmospheric", 6, "GAS", 65, 200.0, 35000.0);
        writeCar(car1, car2);
        for (Car car : getAllCars()) {
            System.out.println(car);
        }
    }

    public static void writeCar(Car... car) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileCars))) {
            objectOutputStream.writeObject(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car[] getAllCars() {
        try (FileInputStream fileInputStream = new FileInputStream(fileCars);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Car[]) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
