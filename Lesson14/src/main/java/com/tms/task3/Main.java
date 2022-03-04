package com.tms.task3;

/**
 * 3) Проверка на цензуру:
 * Создаете 2 файла.
 * 1 - й. Содержит исходный текст.
 * 2 - й. Содержит слова недопустимые в тексте (black list). Структура файла определите сами, хотите каждое слово на новой строке, хотите через запятую разделяйте.
 * Задача: необходимо проверить проходит ли текст цензуру. Если в тексте не встретилось ни одного недопустимого слова, то выводите сообщение о том что текст прошел проверку на цензуру.
 * Если нет, то выводите соответствующее сообщение, кол-во предложений не прошедших проверку и сами предложения подлежащие исправлению.
 */

public class Main {
    public static final String TEXT_FILE = "Lesson14/src/main/java/com/tms/task3/text.txt";
    public static final String BLACKLIST_FILE = "Lesson14/src/main/java/com/tms/task3/blacklist.txt";

    public static void main(String[] args) {
        TextFormatter textFormatter = new TextFormatter();
        String[] sentences = textFormatter.getText(TEXT_FILE).toString().split("[.!?]");
        String[] words = textFormatter.getText(BLACKLIST_FILE).toString().split(" ");
        textFormatter.checkText(sentences, words);
    }

}
