package com.tms.service;

import com.tms.model.Book;
import com.tms.model.FlowerMarket;
import com.tms.model.Reader;

import static com.tms.util.Constants.*;

public class Main {
    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();
        System.out.println(flowerMarket.getBouquet(ROSE, "кактус"));
        System.out.println(flowerMarket.getBouquet(TULIP, ASTER, HERBERA, "хризантема"));
        System.out.println(flowerMarket.getBouquet(LILY, ASTER, CARNATION));
        System.out.println(flowerMarket.getBouquet(ROSE, ROSE, ROSE));
        System.out.println(flowerMarket.getBouquet(CARNATION, CARNATION, ROSE));
        System.out.println("Количество всех проданных цветов- " + flowerMarket.getCountFlowers() + ", на сумму - " + flowerMarket.getCostFlowers() + " руб.");
        System.out.println("----------------------------------------------");
        Reader reader1 = new Reader("Петров В.В.", 101, "Energy", "01.06.1995", 235678);
        Reader reader2 = new Reader("Иванов И.И.", 102, "Economic", "24.11.1989", 231472);
        Reader reader3 = new Reader("Сидоров С.С.", 103, "Philosophical", "07.01.1992", 236754);
        Reader[] readers = {reader1, reader2, reader3};
        Book book1 = new Book(BOOKNAME1, "Шмидт");
        Book book2 = new Book(BOOKNAME2, "Ожегов");
        Book book3 = new Book(BOOKNAME3, "Роулинг");
        System.out.println(reader1.takeBook(3));
        System.out.println(reader1.takeBook(5));
        System.out.println(reader1.returnBook());
        System.out.println(reader1.takeBook(BOOKNAME1, BOOKNAME2, BOOKNAME3, BOOKNAME1));
        System.out.println(reader1.returnBook(BOOKNAME1, BOOKNAME2));
        System.out.println(reader1.takeBook(book1, book2, book3));
        System.out.println(reader1.returnBook(book1, book2));


    }

}
