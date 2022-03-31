package by.teachmeskills.task1.jdbc;

import by.teachmeskills.task1.jdbc.model.CRUDUtils;
import by.teachmeskills.task1.jdbc.model.Item;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        System.out.println("Get:");
        for (Item item : CRUDUtils.getAllItems()) {
            System.out.println(item);
        }
        System.out.println("-------------------------------");
        System.out.println("Add:");
        for (Item item : CRUDUtils.addItem(new Item(2, "Laptop Huawei", "10.1',16 Gb, 4 GB RAM", new BigDecimal(750), 2, true))) {
            System.out.println(item);
        }
        System.out.println("-------------------------------");
        System.out.println("Update:");
        for (Item item : CRUDUtils.updateItem(3, "smartphone", "6,0', 6 GB RAM, 128 GB", new BigDecimal(500), 5, true)) {
            System.out.println(item);
        }
        System.out.println("-------------------------------");
        System.out.println("Delete:");
        for (Item item : CRUDUtils.deleteItem(5)) {
            System.out.println(item);
        }
    }
}
