package by.teachmeskills.eshop.model;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    private String imageName;
    private String name;
    private String description;
    private double price;
}
