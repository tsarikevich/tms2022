package by.teachmeskills.eshop.model;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Order {
    private static int idOrder;
    private int id;
    private BigDecimal price;
    private String date;
    private int user_id;
    private List<Product> products;

    public Order(BigDecimal price, String date, int user_id, List<Product> productsFromCart) {
        this.id = ++this.idOrder;
        this.price = price;
        this.date = date;
        this.user_id = user_id;
        this.products = new ArrayList<>(productsFromCart);
    }
}
