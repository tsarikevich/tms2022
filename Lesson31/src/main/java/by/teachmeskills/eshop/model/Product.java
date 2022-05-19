package by.teachmeskills.eshop.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {
    private int id;
    private String imageName;
    private String name;
    private String description;
    private BigDecimal price;
    private int category_id;
}
