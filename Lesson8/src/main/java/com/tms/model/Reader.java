package com.tms.model;

import com.tms.util.Constants;
import lombok.ToString;

import java.util.Arrays;

/**
 * Читатели библиотеки
 * Определить класс Reader, хранящий такую информацию о пользователе библиотеки:
 * ФИО,
 * номер читательского билета,
 * факультет,
 * дата рождения,
 * телефон.
 * Методы takeBook(), returnBook().
 * Разработать программу, в которой создается массив объектов данного класса.
 * Перегрузить методы takeBook(), returnBook():
 * - takeBook, который будет принимать количество взятых книг. Выводит на консоль сообщение "Петров В. В. взял 3 книги".
 * - takeBook, который будет принимать переменное количество названий книг.
 * Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
 * - takeBook, который будет принимать переменное количество объектов класса Book (создать новый класс, содержащий имя и автора книги).
 * Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
 * Аналогичным образом перегрузить метод returnBook(). Выводит на консоль сообщение "Петров В. В. вернул книги:
 * Приключения, Словарь, Энциклопедия". Или  "Петров В. В. вернул 3 книги"
 */
@ToString
public class Reader {

    private String name;
    private int numberOfTicket;
    private String faculty;
    private String dateOfBirth;
    private int phoneNumber;
    private int numberOfBook;//количество книг, которые взял читатель


    public Reader(String name, int numberOfTicket, String faculty, String dateOfBirth, int phoneNumber) {
        this(name);
        this.numberOfTicket = numberOfTicket;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public Reader(String name) {
        this.name = name;
    }

    public String takeBook(int numberOfBook) {
        this.numberOfBook += numberOfBook;
        return (name + " взял " + numberOfBook + " " + Constants.getEndOfWord(numberOfBook));

    }

    public String takeBook(String... nameBooks) {
        Book[] nameOfBooks = new Book[nameBooks.length];
        for (int i = 0; i < nameBooks.length; i++) {
            Book book = new Book(nameBooks[i]);
            nameOfBooks[i] = book;
        }
        return (name + " взял книги: " + Arrays.toString(nameOfBooks));
    }


    public String takeBook(Book... books) {
        Book[] myBook = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            myBook[i] = books[i];
        }
        return name + " взял книги: " + Arrays.toString(myBook);
    }

    public String returnBook() {
        String endOfWord;
        if (numberOfBook != 0) {
            return (name + " вернул " + numberOfBook + " " + Constants.getEndOfWord(numberOfBook));
        } else {
            return (name + " книг не брал");
        }
    }

    public String returnBook(String... nameBooks) {
        Book[] nameOfBooks = new Book[nameBooks.length];
        for (int i = 0; i < nameBooks.length; i++) {
            Book book = new Book(nameBooks[i]);
            nameOfBooks[i] = book;
        }
        return (name + " вернул книги: " + Arrays.toString(nameOfBooks));
    }

    public String returnBook(Book... books) {
        Book[] myBook = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            myBook[i] = books[i];
        }
        return (name + " вернул книги: " + Arrays.toString(myBook));
    }

}
