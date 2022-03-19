package com.tms.task5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.tms.task5.Person.*;

/**
 * 5) Задан список сотрудников, которые хранятся в коллекции List<p3.com.tms.task5.Person>.
 * Объект p3.com.tms.task5.Person содержит имя и фамилию(по желанию другие данные)
 * a) написать метод, который отображает все фамилии, начинающиеся на букву "Д".
 * Внимание! метод должен вернуть объект Optional<String>.
 * b*)Со звездочкой. Написать метод, который будет выводить в столбик первую букву фамилии и рядом количество сотрудников,
 * у которых фамилия начинается с этой буквы.
 * Пример: Антонов, Петров, Сидоров, Александров...
 * на экран выведет:
 * A - 2 сотрудника
 * П - 1 сотрудник
 * С - 1 сотрудник
 */
public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Иван", "Петров", 20, MALE),
                new Person("Дмитрий", "Дмитриев", 25, MALE),
                new Person("Илья", "Демидов", 23, MALE),
                new Person("Вячеслав", "Дубин", 23, MALE),
                new Person("Никита", "Иванов", 24, MALE),
                new Person("Александр", "Детков", 23, MALE));

        Optional<String> personInfo = getSurnameByLetter(persons, "Д");
        if (personInfo.isPresent()) {
            String name = personInfo.get();
            System.out.println(name);
        }

        Map<String, Integer> personInfo2 = getCountEmployeesByFirstLetterOfSurname(persons);
        for (Map.Entry entry : personInfo2.entrySet()) {
            System.out.println(entry.getKey() + " - " + getNamesEmployee((Integer) entry.getValue()));
        }

        System.out.println("-----------------------------------------");

        Map<String, Long> personInfo3 = getCountEmployeesByFirstLetterOfSurname2(persons);
        for (Map.Entry entry : personInfo3.entrySet()) {
            System.out.println(entry.getKey() + " - " + getNamesEmployee((int) (long) entry.getValue()));
        }
    }
}
