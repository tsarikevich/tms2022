package by.teachmeskills.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {
    private List<Product> products = new ArrayList<>();
    private BigDecimal totalCost = new BigDecimal("0");

    public void addProduct(Product myProduct) {
        BigDecimal price = myProduct.getPrice();
        totalCost = totalCost.add(price);
        products.add(myProduct);

    }

    public void deleteProduct(Product myProduct) {
        BigDecimal price = myProduct.getPrice();
        totalCost = totalCost.subtract(price);
        products.stream()
                .filter(s -> s.equals(myProduct))
                .findFirst()
                .map(product -> products.remove(0))
                .isPresent();

    }
}
