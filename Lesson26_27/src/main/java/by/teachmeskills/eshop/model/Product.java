package by.teachmeskills.eshop.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Product {
    private int id;
    private String imageName;
    private String name;
    private String description;
    private BigDecimal price;
    private int category_id;
}
