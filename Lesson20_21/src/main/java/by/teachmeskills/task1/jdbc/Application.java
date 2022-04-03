package by.teachmeskills.task1.jdbc;

import by.teachmeskills.task1.jdbc.model.CRUDUtils;
import by.teachmeskills.task1.jdbc.model.Item;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        System.out.println("Get:");
        CRUDUtils.getAllItems().forEach(System.out::println);

        System.out.println("-------------------------------");
        System.out.println("Add:");
        CRUDUtils.addItem(new Item("Laptop Huawei", "10.1',16 Gb, 4 GB RAM", new BigDecimal(750), 2, true)).forEach(System.out::println);

        System.out.println("-------------------------------");
        System.out.println("Update:");
        CRUDUtils.updateItem(3, "smartphone", "6,0', 6 GB RAM, 128 GB", new BigDecimal(500), 5, true).forEach(System.out::println);

        System.out.println("-------------------------------");
        System.out.println("Delete:");
        CRUDUtils.deleteItem(5).forEach(System.out::println);
    }
}
