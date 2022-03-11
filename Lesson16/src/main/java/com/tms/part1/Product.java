package com.tms.part1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Необходимо реализовать магазин продуктов.
 * Создать класс Товар, поля:
 * • id(целое число)
 * • name(строка)
 * • price(целое число)
 * Создать класс Магазин, поля:
 * • Список товаров (изначально пустой)
 * методы:
 * • добавить товар(принимает объект товара и добавляет его в список
 * товаров). При попытке добавить товар с id уже существующем в списке,
 * вставка производится не должна
 * • получить все товары(метод ВОЗВРАЩАЕТ список всех товаров в
 * магазине)
 * • удалить товар (метод принимает id товара и удаляет из списка товар с
 * соответствующим id)
 * • редактировать товар(принимает объект товара и редактирует им список
 * товаров)
 * Обратите внимание что id товара и индекс товара в списке — это разные вещи, не перепутайте.
 * Id товара — это поле вашего объекта, вы при его создании его задаете. А индекс товара в списке товаров,
 * это по сути его порядковый номер в списке(начинается с 0).
 * (обязательное к выполнению): В main:
 * • создаем объект магазина
 * • создаем пару тройку товаров и добавляем эти товары в магазин
 * • получаем список товаров из магазина, сортируем по цене(по
 * возрастанию) и выводим в консоль.
 * • удаляем один товар
 * • получаем список товаров из магазина, сортируем по порядку
 * добавления(последние добавленные в начале) и выводим в консоль.
 * • редактируем один товар
 * • получаем список товаров и выводим в консоль
 * Если вы выполнили обязательную часть, можете переходить к более интересному пункту.
 * Для работы с магазином используем не вызовы методов из main(все что до этого написали можно удалить),
 * а разрабатываем консольное меню для работы с магазином.
 */
@ToString
@Getter
@Setter
public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


//    @Override
//    public int compare(Product o1, Product o2) {
//        if (o1.getPrice() == o2.getPrice()) {
//            return 0;
//        }
//        if (o1.getPrice() > o2.getPrice()) {
//            return 1;
//        }
//        if (o1.getPrice() < o2.getPrice()) {
//            return -1;
//        }
//        return 0;
//    }

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
