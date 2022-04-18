package by.teachmeskills.eshop.model;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
}
