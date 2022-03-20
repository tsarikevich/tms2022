package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 2) Напишите программу, читающую из System.in текст в кодировке UTF-8,
 * подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее
 * часто встречающихся слов.
 * <p>
 * Словом будем считать любую непрерывную последовательность символов, состоящую
 * только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов:
 * "Мама", "мыла", "раму", "33" и "раза".
 * <p>
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" —
 * это одно и то же слово. Выводите слова в нижнем регистре.
 * <p>
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 * <p>
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя
 * однозначно упорядочить только по частоте, то дополнительно упорядочите слова
 * с одинаковой частотой в лексикографическом порядке.
 * <p>
 * Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
 */
public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, UTF_8))) {

            Map<String, Long> map = reader
                    .lines()
                    .limit(1)
                    .flatMap(s -> Arrays.stream(s.split("[\\p{Blank}\\p{Punct}]+"))
                            .flatMap(String::lines))
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .limit(10)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
