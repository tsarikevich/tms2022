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
        readWriteCar(car1);
        readWriteCar(car2);

    }

    public static void readWriteCar(Car car) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileCars));
            objectOutputStream.writeObject(car);
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileCars));
            Car carFromFile = (Car) objectInputStream.readObject();
            System.out.println(carFromFile);
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
