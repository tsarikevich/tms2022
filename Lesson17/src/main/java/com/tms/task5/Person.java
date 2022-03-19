package com.tms.task5;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    private String name;
    private String surname;
    private Integer age;
    private String sex = FEMALE;


    public Person(String name, String surname, Integer age, String sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public static Optional<String> getSurnameByLetter(List<Person> persons, String letter) {
        return persons.stream()
                .map(Person::getSurname)
                .filter(s -> s.startsWith(letter))
                .reduce((s1, s2) -> s1 + "\n" + s2);
    }

    public static String getNamesEmployee(int value) {
        if (value % 10 == 1 && value % 100 != 11) {
            return value + " сотрудник";
        } else if (value % 10 >= 2 && value % 10 <= 4 && !(value % 100 >= 12 && value % 100 <= 14)) {
            return value + " сотрудника";
        } else {
            return value + " сотрудников";
        }
    }

    //Способ 1
    public static Map<String, Integer> getCountEmployeesByFirstLetterOfSurname(List<Person> persons) {
        Map<String, Integer> map = new HashMap<>();
        List<String> firstLetters = persons.stream()
                .map(s -> s.getSurname().substring(0, 1)).toList();
        for (String string : firstLetters) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        return map;
    }

    //Способ 2
    public static Map<String, Long> getCountEmployeesByFirstLetterOfSurname2(List<Person> persons) {
        return persons.stream()
                .map(s -> s.getSurname().substring(0, 1))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
