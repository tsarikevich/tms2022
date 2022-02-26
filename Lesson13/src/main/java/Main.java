

public class Main {
    public static void main(String[] args) {
        /**
         * 1) Вырезать подстроку из строки начиная с первого вхождения символа(А) до, последнего вхождения сивола(B).*/
        StringBuilder s = new StringBuilder("AUBERGINE");
        if (s.indexOf("A") != -1 && s.indexOf("B") != -1) {
            System.out.println(s.substring(s.indexOf("A"), s.lastIndexOf("B") + 1)); //включая символ B
        }

        /** 2) Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в позиции 0*/
        StringBuilder s1 = new StringBuilder("Hello World");
        if (!s1.isEmpty() && s1.length() >= 3) {
            StringBuilder s2 = new StringBuilder().insert(0, s1.charAt(3));
            for (int i = 0; i < s1.length(); i++) {
                if (s2.charAt(0) == s1.charAt(i)) {
                    s1.setCharAt(i, s1.charAt(0));
                }
            }
            System.out.println(s1);
            //или
            String s4 = "Hello World";
            if (!s4.isEmpty()) {
                s4 = s4.replace('l', 'H');
                System.out.println(s4);
            }
        }
        /** 3) В массиве находятся слова. Вывести на экран слова палиндромы
         *(т.е которые читаются справа на лево и слева на право одинаково, например: заказ, казак, дед...)*/
        StringBuilder[] words = new StringBuilder[]{new StringBuilder("доход"), new StringBuilder("машина"), new StringBuilder("репер"), new StringBuilder("карета"), new StringBuilder("довод")};
        for (StringBuilder word : words) {
            StringBuilder tempWord = new StringBuilder(word).reverse();
            if (word.toString().equals(tempWord.toString())) {
                System.out.println(word);
            }
        }
        /** 4) Есть строка в которой содержится текст, предложения разделены точками.
         * * После запуска программы на экран должны выводиться только те предложения в которых от 3-х до 5-ти слов.
         * Если в предложении присутствует слово-палиндром, то не имеет значения какое количество слов в предложении, оно выводится на экран.
         * Пишем все в ООП стиле.
         * 1. Метод принимает строку и возвращает кол-во слов в строке.
         * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
         * В main создаем строку с текстом, также можно текст задавать с консоли.
         * Разбиваем текст на предложения. Используя методы класса TextFormatter определяем подходит ли нам предложение.
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



