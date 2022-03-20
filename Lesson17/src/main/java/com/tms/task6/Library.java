package com.tms.task6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Library {
    private List<Book> books;
    private List<Reader> readers;


    public void sendNews(List<EmailAddress> emailAddresses) {
        if (!emailAddresses.isEmpty()) {
            System.out.println("Новая рассылка отправлена на следующие адреса:");
            emailAddresses.stream()
                    .map(EmailAddress::getEmail)
                    .forEach(System.out::println);
        } else {
            System.out.println("Нет адресов для рассылки");
        }
    }

    public void sendMessageByBooks(Map<String, List<EmailAddress>> map) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey().equals("OK")) {
                System.out.println("Новая рассылка направлена на " + entry.getValue());
            } else {
                System.out.println(entry.getValue() + " напоминаем о сроках возврата книг");
            }

        }
    }

    public void getNameAllBookByAge(Library library) {
        library.getBooks().stream()
                .sorted(Comparator.comparing(Book::getAge))
                .forEach(System.out::println);
    }

    public Boolean checkIsBookWasTakeByAuthor(Library library, String author) {
        return library.getReaders()
                .stream()
                .flatMap(reader -> reader.getBooks().stream())
                .anyMatch(book -> book.getAuthor().equals(author));
    }

    public int getMaxNumberBookOneReaderHas(Library library) {
        return library.getReaders().stream()
                .map(reader -> reader.getBooks().size())
                .reduce((a, b) -> a > b ? a : b)
                .orElse(0);
    }
}

