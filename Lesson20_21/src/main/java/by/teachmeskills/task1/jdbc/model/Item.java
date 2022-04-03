
package by.teachmeskills.task1.jdbc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Item {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private boolean isAvailability;

    public Item(String name, String description, BigDecimal price, int quantity, boolean isAvailability) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.isAvailability = isAvailability;
    }

    public Item(int id, String name, String description, BigDecimal price, int quantity, boolean isAvailability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.isAvailability = isAvailability;


    }
}