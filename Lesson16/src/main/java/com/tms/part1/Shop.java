package com.tms.part1;

import lombok.Getter;

import java.util.*;

@Getter
public class Shop {
    private Set<Product> products = new LinkedHashSet<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Set<Product> getSortedByPrice(Set<Product> products) {
        Set<Product> sortProducts = new TreeSet<>(products);
        return sortProducts;
    }

    public void deleteProduct(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            int id1 = iterator.next().getId();
            if (id == id1) {
                iterator.remove();
            }
        }
    }

    public void editProduct(Product product) {
        for (Product shopProduct : products) {
            if (shopProduct.getId() == product.getId()) {
                shopProduct.setPrice(product.getPrice());
                shopProduct.setName(product.getName());
            }
        }
    }

    public List<Product> getSortedReverse(Set<Product> products) {
        List<Product> sortProducts = new ArrayList<>(products);
        Collections.reverse(sortProducts);
        return sortProducts;
    }
}




