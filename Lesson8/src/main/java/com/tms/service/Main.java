package com.tms.service;

import com.tms.model.Book;
import com.tms.model.FlowerMarket;
import com.tms.model.Reader;
import com.tms.util.Constants;

public class Main {
    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket(Constants.allFlowers);
        System.out.println(flowerMarket.getBouquet(Constants.ROSE, Constants.CARNATION, Constants.LILY, Constants.ROSE, Constants.TULIP, Constants.HERBERA));
        System.out.println(flowerMarket.getBouquet(Constants.TULIP, Constants.ASTER, Constants.HERBERA));
        System.out.println(flowerMarket.getBouquet(Constants.LILY, Constants.ASTER, Constants.CARNATION));
        System.out.println(flowerMarket.getBouquet(Constants.ROSE, Constants.ROSE, Constants.ROSE));
        System.out.println(flowerMarket.getBouquet(Constants.CARNATION, Constants.CARNATION, Constants.ROSE));
        System.out.println("Количество всех проданных цветов- " + FlowerMarket.countFlowers + ", на сумму - " + FlowerMarket.costFlowers + " руб.");
        System.out.println("----------------------------------------------");
        Reader reader1 = new Reader("Петров В.В.", 101, "Energy", "01.06.1995", 235678);
        Reader reader2 = new Reader("Иванов И.И.", 102, "Economic", "24.11.1989", 231472);
        Reader reader3 = new Reader("Сидоров С.С.", 103, "Philosophical", "07.01.1992", 236754);
        Reader[] readers = {reader1, reader2, reader3};
        Book book1 = new Book(Constants.BOOKNAME1, "Шмидт");
        Book book2 = new Book(Constants.BOOKNAME2, "Ожегов");
        Book book3 = new Book(Constants.BOOKNAME3, "Роулинг");
        System.out.println(reader1.takeBook(3));
        System.out.println(reader1.returnBook());
        System.out.println(reader1.takeBook(Constants.BOOKNAME1, Constants.BOOKNAME2, Constants.BOOKNAME3, Constants.BOOKNAME1));
        System.out.println(reader1.returnBook(Constants.BOOKNAME1, Constants.BOOKNAME2));
        System.out.println(reader1.takeBook(book1, book2, book3));
        System.out.println(reader1.returnBook(book1, book2));


    }

}
