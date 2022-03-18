package com.tms.task6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

/**
 * 6) Пишем библиотеку.
 * Для каждой книги библиотечного фонда известны автор, название и год издания.
 * Для читателя библиотеки будем хранить ФИО и электронный адрес. Каждый читатель может взять в библиотеке одну или несколько книг.
 * Ещё нам понадобится флаг читательского согласия на уведомления по электронной почте.
 * Рассылки организуют сотрудники библиотеки: напоминают о сроке возврата книг, сообщают новости.
 * Создаем классы:
 * - Book с полями Автор, Название, Год издания
 * - Reader(читатель) с полями ФИО, электронный адрес, флаг согласия на рассылку, список взятых книг
 * - EmailAddress  с полями электронный адрес, дополнительная информация
 * - Library содержит список книг и список читателей.
 * <p>
 * Задачи:
 * a) Получить список всех книг библиотеки, отсортированных по году издания.
 * b) Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
 * При этом флаг согласия на рассылку учитывать не будем: библиотека закрывается, так что хотим оповестить всех.
 * c) Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей, которые согласились на рассылку.
 * Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
 * d) Получить список всех книг, взятых читателями.
 * Список не должен содержать дубликатов (книг одного автора, с одинаковым названием и годом издания).
 * e) Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Пушкина Александра Сергеевича.
 * <p>
 * Задачи со ЗВЕЗДОЧКОЙ:
 * а) Узнать наибольшее число книг, которое сейчас на руках у читателя.
 * b) Необходимо рассылать разные тексты двум группам:
 * * тем, у кого взято меньше двух книг, просто расскажем о новинках библиотеки;
 * * тем, у кого две книги и больше, напомним о том, что их нужно вернуть в срок.
 * То есть надо написать метод, который вернёт два списка адресов (типа EmailAddress): с пометкой OK — если книг не больше двух,
 * или TOO_MUCH — если их две и больше. Порядок групп не важен.
 * с) Для каждой группы (OK, TOO_MUCH) получить списки читателей в каждой группе.
 * d) Для каждой группы (OK, TOO_MUCH) получить ФИО читателей в каждой группе, перечисленные через запятую.
 * И ещё каждый такой список ФИО нужно обернуть фигурными скобками.
 * Пример: TOO_MUCH {Иванов Иван Иванович, Васильев Василий Васильевич}
 * OK {Семёнов Семён Семёнович}
 */
public class Main {
    public static void main(String[] args) {
        List<Book> allBooks = Arrays.asList(
                new Book("Н.Г. Чернышевский", "Что делать?", 1980),
                new Book("И.С. Тургенев", "Рудин. Дворянское гнездо. Повести", 1978),
                new Book("Г.И. Успенский", "Нравы Растеряевой улицы. Рассказы", 1984),
                new Book("А.И. Герцен", "Кто виноват? Повести. Рассказы", 1981),
                new Book("А.П. Чехов", "Толстый и тонкий", 1985),
                new Book("А.С. Пушкин", "Евгений Онегин", 2015)
        );
        List<Reader> readers = Arrays.asList(
                new Reader("Иванов Иван Иванович", "ivan@mail.ru", false,
                        Arrays.asList(
                                new Book("Н.Г. Чернышевский", "Что делать?", 1980),
                                new Book("Г.И. Успенский", "Нравы Растеряевой улицы. Рассказы", 1984),
                                new Book("А.П. Чехов", "Толстый и тонкий", 1985)
                        )),
                new Reader("Васильев Василий Васильевич", "vasiliy@mail.ru", true,
                        Arrays.asList(
                                new Book("А.П. Чехов", "Толстый и тонкий", 1985),
                                new Book("А.С. Пушкин", "Евгений Онегин", 2015)
                        )),
                new Reader("Семёнов Семён Семёнович", "semen@mail.ru", true,
                        Arrays.asList(
                                new Book("Н.Г. Чернышевский", "Что делать?", 1980),
                                new Book("И.С. Тургенев", "Рудин. Дворянское гнездо. Повести", 1978),
                                new Book("Г.И. Успенский", "Нравы Растеряевой улицы. Рассказы", 1984),
                                new Book("А.И. Герцен", "Кто виноват? Повести. Рассказы", 1981),
                                new Book("А.П. Чехов", "Толстый и тонкий", 1985),
                                new Book("А.С. Пушкин", "Евгений Онегин", 2015)

                        )));

        Library library = new Library(allBooks, readers);
//        library.getBooks().stream().sorted(Comparator.comparing(Book::getAge)).forEach(System.out::println);

        List<EmailAddress> emailAddressReaders1 = library.getReaders().stream()
                .map(Reader::getEmail)
                .map(EmailAddress::new)
                .distinct()
                .toList();
//        library.sendNews(emailAddressReaders1);

        List<EmailAddress> emailAddressReaders2 = library.getReaders().stream()
                .filter(Reader::isMailing)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(Reader::getEmail)
                .distinct()
                .map(EmailAddress::new)
                .toList();
//        System.out.println(emailAddressReaders2);
//        library.sendNews(emailAddressReaders2);
        List<Book> books = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .distinct()
                .toList();
//        books.stream().forEach(System.out::println);

        Boolean isTakeBookByAuthor = library.getReaders()
                .stream()
                .flatMap(reader -> reader.getBooks().stream())
                .anyMatch(book -> book.getAuthor().equals("А.С. Пушкин"));
        System.out.println(isTakeBookByAuthor);

        int maxNumberBooks = library.getReaders().stream()
                .map(reader -> reader.getBooks().size())
                .reduce((a, b) -> a > b ? a : b)
                .orElse(0);
        System.out.println(maxNumberBooks);

        Map<String, List<EmailAddress>> map = library.getReaders().stream()
                .filter(Reader::isMailing)
                .collect(groupingBy(b -> b.getBooks().size() > 2 ? "TOO_MUCH" : "OK",
                        mapping(email -> new EmailAddress(email.getEmail()), Collectors.toList())));
        System.out.println(map);
        library.sendMessageByBooks(map);

    }
}
