package com.tms.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@AllArgsConstructor
public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(com.tms.part1.Product o) {
        if (this.getPrice() == o.getPrice()) {
            if (!(this.getName().equals(o.getName()))) {
                return -1;
            }
        }
        if (this.getPrice() < o.getPrice()) {
            return -1;
        }
        if (this.getPrice() > o.getPrice()) {
            return 1;
        }
        return 0;
    }
}
