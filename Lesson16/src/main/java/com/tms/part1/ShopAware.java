package com.tms.part1;

import java.util.List;
import java.util.Set;

public interface ShopAware {


    void addProduct(Product product);

    Set<Product> getSortedByIncreasePrice();

    List<Product> getSortedByDecreasePrice();

    void deleteProduct(int id);

    void editProduct(Product product);

    List<Product> getSortedReverse();

    Set<Product> getProducts();
}
