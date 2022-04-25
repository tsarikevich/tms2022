package by.teachmeskills.eshop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Category {
    private String id;
    private String name;
    private String imageName;
    private List<Product> productList;

    public Category(String name, String imageName, String id) {
        this.name = name;
        this.imageName = imageName;
        this.id = id;
    }

}
