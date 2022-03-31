package by.teachmeskills.task1.jdbc.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Item {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private boolean isAvailability;

}
