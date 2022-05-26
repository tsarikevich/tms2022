package by.teachmeskills.eshop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderStorage {
    private static List<Order> orders = new ArrayList<>();

    public static void addNewOrder(Order order) {
        orders.add(order);
    }

    public static List<Order> getOrdersByUserId(int userId) {
        return orders.stream()
                .filter(order -> order.getUser_id() == userId)
                .collect(Collectors.toList());
    }
}
