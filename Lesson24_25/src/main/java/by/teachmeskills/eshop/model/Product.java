package by.teachmeskills.eshop.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {
    private String imageName;
    private String name;
    private String description;
    private double price;
}
