package com.tms.regexp;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public static void main(String[] args) {
        /**
         * По строкам дополнительная!
         *  1) Даны строки разной длины c четным числом символов(казаки, просмотреть и так далее),
         *  необходимо вернуть ее два средних знака.
         * Например, если дана строка "string"  результат будет "ri", для строки "code" результат "od",  для "Practice" результат "ct".
         */
        String task1 = "Казаки";
        System.out.println(task1.substring(task1.length() / 2 - 1, task1.length() / 2 + 1));

        /** По  регулярным выражениям!
         * 2) Дана строка "cab, ccab, cccab" Необходимо составить регулярное выражение, сделать класс Pattern, Matcher, вызвать метод find и вывести слова на консоль
         * Должно вывести:
         * cab
         * ccab
         * cccab
         */
        String string = "cab, ccab, cccab";
        Pattern pattern = Pattern.compile("c+.b");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());

        }
        /** 3) Дана строка "Versions: Java  5, Java 6, Java   7, Java 8, Java 12."
         * Найти все подстроки "Java X", где X - число и распечатать их.*/
        String versions = "Java  5, Java 6, Java   7, Java 8, Java 12";
        Pattern pattern1 = Pattern.compile("Java\\s+\\d+");
        Matcher matcher1 = pattern1.matcher(versions);
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }

        /** 4*)со звездочкой! Предложение состоит из нескольких слов, разделенных пробелами. Например: "One two three раз два три one1 two2 123 ".
         * Найти количество слов, содержащих только символы латинского алфавита.
         * Необходимо составить регулярное выражение и вызвать его в методе split(Regexp)
         * String str = "One two three раз два три one1 two2 123 ";
         * System.out.println(str.split("регулярное выражение").length);
         * Подсказка: тут надо использовать:
         * 1) группы ()
         * 2) | - оператор или
         * 3) [] - группировки символов
         * 4) +,* - квантификаторы
         * <p>
         * PS: Кто не сможет осилить регулярное выражение, то сделайте как сможете!
         */

        String str = "One two three раз два три one1 two2 123 ";
        System.out.println(Arrays.toString(str.split("([а-яА-Я ]+)|([0-9 ]+)")));

/** 5*)со звездочкой! В метод на вход приходит строка
 * <p>
 * public static boolean validate(String str) {
 * return false;
 * }
 * Необходимо выполнить проверку на валидацию входящей строки и вернуть false или true
 * - Строка должна содержать только маленькие латинские буквы и цифры 1 или 5 без знака подчеркивания.
 * - Длина строки должна быть от 4 до 20 символов.
 * <p>
 * PS: нужно посмотреть презентацию страница 44 (Метасимволы для группировки символов)
 */
        String string1 = "a1l5jk1jk5";
        System.out.println(validate(string1));
    }

    public static boolean validate(String str) {
        return str.matches("[a-z15]{4,20}");
    }
}
