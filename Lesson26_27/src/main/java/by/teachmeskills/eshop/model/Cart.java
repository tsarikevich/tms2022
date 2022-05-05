package by.teachmeskills.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product myProduct) {
        products.add(myProduct);
    }

    public void deleteProduct(Product myProduct) {
        products.stream()
                .filter(s -> s.equals(myProduct))
                .findFirst()
                .map(product -> products.remove(0))
                .isPresent();
    }
}
