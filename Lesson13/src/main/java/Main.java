import java.util.Arrays;

/**
 * 5)Даны строки разной длины (длина - четное число), необходимо вернуть ее два средних знака:
 * Пример: "string" → "ri", "code" → "od", "Practice"→"ct".
 * 6)Создать класс Employee, у которого есть переменные класса - String fullname, double salary.
 * Создать массив содержащий несколько объектов этого типа. Создать класс Report (по возможности интерфейс),
 * который будет содержать метод generateReport, в котором выводится информация о зарплате всех сотрудников.
 * Используйте форматировании строк(https://javarush.ru/quests/lectures/questmultithreading.level02.lecture06)
 * Пусть salary будет выровнено по правому краю, десятичное значение имеет 2 знака после запятой и по одной первой букве имени и отчества через точки.
 * Пример: | Л.Н. Толстой		|		200.34|
 * 7*(Можно не делать!))Найти количество слов, содержащих только символы латинского алфавита. Пример:
 * "Методы доступа называют ещё аксессорами (от англ. access — доступ), или по отдельности — геттерами (англ. get — чтение) and сеттерами (англ. set — запись)"
 */

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
        String s4 = "Меня зовут Максим.Мне 32 года.Я инженер";
        String[] s5 = s4.split("\\.");
        System.out.println(Arrays.toString(s5));
        for (int i = 0; i < s5.length; i++) {
            String[] s6 = s5[i].split(" ");
            if (s6.length == 3) {
                String s7 = s5[i];
                System.out.println(s7);
            }
        }


    }

}



