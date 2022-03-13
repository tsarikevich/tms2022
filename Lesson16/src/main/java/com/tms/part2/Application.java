package com.tms.part2;

import com.tms.part1.Product;
import com.tms.part1.Shop;
import com.tms.part1.ShopAware;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Application {
    private final Scanner SCANNER = new Scanner(System.in);
    private final ShopAware SHOP;

    public Application() {
        this.SHOP = new Shop();
    }

    public void start() throws InputMismatchException {
        System.out.println("Добро пожаловать в наш магазин!");
        while (true) {
            System.out.println("""
                                        
                    Выберите действие, которое хотите выполнить:
                    1. Вывод всех товаров
                    2. Добавить товар
                    3. Удалить товар
                    4. Редактировать товар по id
                    5. Выход из программы
                    """);
            switch (SCANNER.nextInt()) {
                case 1 -> showProduct();
                case 2 -> addNewProduct();
                case 3 -> deleteProductById();
                case 4 -> editProductById();
                case 5 -> {
                    System.out.println("Ждём Вас в нашем магазине снова!");
                    return;
                }
            }
        }
    }

    private void showProduct() {
        System.out.println("""
                Выберите тип отображения товаров:
                1. По цене возрастанию цены
                2. По убыванию цены
                3. По добавлению (сначала новые, потом более старые)
                """);
        switch (SCANNER.nextInt()) {

            case 1:
                if (isProduct()) {
                    SHOP.getSortedByIncreasePrice().forEach(System.out::println);
                }
                break;
            case 2:
                if (isProduct()) {
                    SHOP.getSortedByDecreasePrice().forEach(System.out::println);
                }
                break;
            case 3:
                if (isProduct()) {
                    SHOP.getSortedReverse().forEach(System.out::println);
                }
                break;
            case 4:
                break;
        }
    }

    private void addNewProduct() {
        System.out.println("Введите id товара:");
        int id = getData();
        System.out.println("Введите название товара:");
        String name = SCANNER.next();
        System.out.println("Введите стоимость товара:");
        int price = getData();
        SHOP.addProduct(new Product(id, name, price));
    }

    private void deleteProductById() {
        if (isProduct()) {
            System.out.println("Введите id товара, который Вы хотите удалить");
            int idForDelete = getData();
            if (isProductExist(idForDelete)) {
                SHOP.deleteProduct(idForDelete);
                System.out.println("Товар с id=" + idForDelete + " удалён");
            } else {
                System.out.println("Товара с id=" + idForDelete + " нет в магазине");
            }
        }
    }

    private void editProductById() {
        if (isProduct()) {
            System.out.println("Введите id редактируемого товара:");
            int idForEdit = getData();
            if (isProductExist(idForEdit)) {
                System.out.println("Введите новое название товара:");
                String newName = SCANNER.next();
                System.out.println("Введите новую стоимость товара:");
                int newPrice = getData();
                SHOP.editProduct(new Product(idForEdit, newName, newPrice));
                System.out.println("Товар отредактирован");
            } else {
                System.out.println("Товара с id=" + idForEdit + " нет в магазине");
            }
        }
    }

    private boolean isNumeric(String string) {
        if (string.matches("\\D+")) {
            System.out.println("Вводимые данные не соответствую требованиям (необходимо ввести число).\nПопробуйте заново");
            return false;
        } else {
            return true;
        }
    }

    private int getData() {
        String data;
        do {
            data = SCANNER.next();
        } while (!isNumeric(data));
        return Integer.parseInt(data);
    }

    private boolean isProduct() {
        if (SHOP.getProducts().size() == 0) {
            System.out.println("На данный момент товары отсутствуют. Пожалуйста, добавьте товар");
            return false;
        } else {
            return true;
        }
    }

    private boolean isProductExist(int id) {
        for (Product product : SHOP.getProducts()) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
}



