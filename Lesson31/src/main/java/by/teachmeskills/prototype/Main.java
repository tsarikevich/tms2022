package by.teachmeskills.prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transport> transports = new ArrayList<>();
        List<Transport> transportsCopy = new ArrayList<>();
        Car audi = Car.builder()
                .price(40000)
                .color("black")
                .numberWheels(4)
                .model("Audi")
                .build();
        AirCraft boeing = AirCraft.builder()
                .price(25000)
                .color("white")
                .numberWheels(8)
                .model("Boeing")
                .build();
        transports.add(audi);
        Car audiCopy = (Car) audi.clone();
        System.out.println("Копия объекта audi имеет следующие характеристики: \nцвет - " + audiCopy.getColor() + ";\nназвание модели - " + audiCopy.getModel() + ";\nцена -  " + audiCopy.getPrice() + ";\nколичество колёс -  " + audiCopy.getNumberWheels());
        System.out.println("-------------------------------------------------");
        transports.add(boeing);
        cloneAndCompare(transports, transportsCopy);
    }

    private static void cloneAndCompare(List<Transport> transports, List<Transport> prototypeTransport) {
        for (Transport transport : transports) {
            prototypeTransport.add(transport.clone());
        }
        for (int i = 0; i < transports.size(); i++) {
            if (transports.get(i) != prototypeTransport.get(i)) {
                System.out.println(transports.get(i) + ": Разные объекты по ссылкам");
                if (transports.get(i).equals(prototypeTransport.get(i))) {
                    System.out.println(transports.get(i) + ": Одинаковые объекты по полям");
                } else {
                    System.out.println(transports.get(i) + ": Неодинаковые объекты по полям");
                }
            } else {
                System.out.println(transports.get(i) + ": Одинаковые объекты по ссылкам");
            }
        }
    }
}

