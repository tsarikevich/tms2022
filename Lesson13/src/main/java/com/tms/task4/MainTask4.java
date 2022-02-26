package com.tms.task4;

public class MainTask4 {
    public static void main(String[] args) {
        /** 4) Есть строка в которой содержится текст, предложения разделены точками.
         * * После запуска программы на экран должны выводиться только те предложения в которых от 3-х до 5-ти слов.
         * Если в предложении присутствует слово-палиндром, то не имеет значения какое количество слов в предложении, оно выводится на экран.
         * Пишем все в ООП стиле.
         * 1. Метод принимает строку и возвращает кол-во слов в строке.
         * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
         * В main создаем строку с текстом, также можно текст задавать с консоли.
         * Разбиваем текст на предложения. Используя методы класса com.tms.task4.TextFormatter определяем подходит ли нам предложение.
         * Если подходит, то выводим на экран.
         * */

        String s4 = "Меня зовут Максим. Мне 33 года. Я инженер довод";
        TextFormatter textFormatter = new TextFormatter();
//        System.out.println("Количество слов в тексте - "+textFormatter.getCountWords(s4));
//        System.out.println(textFormatter.getSentencesFromText());
//        System.out.println(textFormatter.getWords());
        System.out.println(textFormatter.isWordsPalindromeInSentence(s4));
//        textFormatter.printSentencesWithPalindrome();
//        System.out.println(textFormatter.getWordsFromText(textFormatter.getSentences(s4)));

//        textFormatter.getWords(s4);
//        String[] s5 = s4.split("\\.");
//        System.out.println(Arrays.toString(s5));
//        for (int i = 0; i < s5.length; i++) {
//            String[] s6 = s5[i].split(" ");
//            if (s6.length == 3) {
//                String s7 = s5[i];
//                System.out.println(s7);
//            }
//        }
    }
}



