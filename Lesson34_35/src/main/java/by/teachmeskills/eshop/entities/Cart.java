package by.teachmeskills.eshop.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Cart {
    private Map<Product, Integer> products;
    private BigDecimal totalCost = BigDecimal.ZERO;

    public Cart() {
        this.products = new LinkedHashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
        BigDecimal price = product.getPrice();
        totalCost = totalCost.add(price);
    }

    public void deleteProduct(Product product) {
        if (products.get(product) > 1) {
            products.put(product, products.get(product) - 1);
        } else {
            products.remove(product);
        }
        BigDecimal price = product.getPrice();
        totalCost = totalCost.subtract(price);
    }

    public List<Product> getListProducts() {
        return new ArrayList<>(products.keySet());
    }

    public List<Integer> getListNumbers() {
        return new ArrayList<>(products.values());
    }

    public BigDecimal getTotalPrice() {
        return totalCost;
    }

    public void clear() {
        products.clear();
    }
}
