package com.tms.part1;

import lombok.Getter;

import java.util.*;

@Getter
public class Shop implements ShopAware {
    private Set<Product> products = new LinkedHashSet<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }


    @Override
    public Set<Product> getSortedByIncreasePrice() {
        Set<Product> sortProducts = new TreeSet<>(products);
        return sortProducts;
    }

    @Override
    public List<Product> getSortedByDecreasePrice() {
        Set<Product> sortProducts = new TreeSet<>(products);
        List<Product> sortProductsByDecreasePrice = new ArrayList<>(sortProducts);
        Collections.reverse(sortProductsByDecreasePrice);
        return sortProductsByDecreasePrice;
    }

    @Override
    public void deleteProduct(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            int id1 = iterator.next().getId();
            if (id == id1) {
                iterator.remove();
                break;
            }
        }
    }


    @Override
    public void editProduct(Product product) {
        for (Product shopProduct : products) {
            if (shopProduct.getId() == product.getId()) {
                shopProduct.setPrice(product.getPrice());
                shopProduct.setName(product.getName());
                break;
            }

        }
    }

    @Override
    public List<Product> getSortedReverse() {
        List<Product> sortProducts = new ArrayList<>(products);
        Collections.reverse(sortProducts);
        return sortProducts;
    }
}




