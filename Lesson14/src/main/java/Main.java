import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 1)В исходном файле hw1/input.txt находятся слова, каждое слово на новой строке.
 * После запуска программы должен создать файл output.txt, который будет содержать в себе только палиндромы.
 * 2)Текстовый файл hw2/input.txt содержит текст.
 * После запуска программы в другой файл должны записаться только те предложения, в которых от 3-х до 5-ти слов.
 * Если в предложении присутствует слово-палиндром, то не имеет значения какое кол-во слов в предложении, оно попадает в output.txt файл.
 * Пишем все в ООП стиле. Создаем класс TextFormatter
 * в котором два метода:
 * 1. Метод принимает строку и возвращает кол-во слов в строке.
 * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
 * В main считываем файл.
 * Разбиваем текст на предложения. Используя методы класса TextFormatter определяем подходит ли нам предложение.
 * Если подходит добавляем его в output.txt файл
 * 3) Проверка на цензуру:
 * Создаете 2 файла.
 * 1 - й. Содержит исходный текст.
 * 2 - й. Содержит слова недопустимые в тексте (black list). Структура файла определите сами, хотите каждое слово на новой строке, хотите через запятую разделяйте.
 * Задача: необходимо проверить проходит ли текст цензуру. Если в тексте не встретилось ни одного недопустимого слова, то выводите сообщение о том что текст прошел проверку на цензуру.
 * Если нет, то выводите соответствующее сообщение, кол-во предложений не прошедших проверку и сами предложения подлежащие исправлению.
 * 4) Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров), бак(тип топлива, объем), скорость, цена). Количество цилиндров не должно сереализоватся в файл(это конфедициальная информация)
 * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль
 * 5) Задача со *
 * Скопировать объект Car из пакета hw5, добавить библиотеки
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.12.3
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.12.3
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/2.12.3
 * через maven в проект. Далее вычитать данные в json формате из файла (hw5/car.json), руками файл изменять нельзя!
 * Преобразовать прочитанные данные в объект hw5.Car (название полей редактировать нельзя, добавлять поля также нельзя) и вывести на консоль объект через System.out.println();
 */

public class Main {
    public static final String OUTPUT_FILE = "Lesson14/src/main/java/hw1/input.txt";
    public static final String INPUT_FILE = "Lesson14/src/main/java/hw1/output.txt";

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(OUTPUT_FILE);
//            outputStream = new FileOutputStream(INPUT_FILE);
            StringBuilder stringBuilder = new StringBuilder();
            int value;
            while ((value = inputStream.read()) != -1) {
                stringBuilder.append((char) value);

            }
            System.out.println(stringBuilder.toString());
        } catch (Exception exception) {
            System.out.println("Unexpected error " + exception);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException exception) {
                System.out.println("Unexpected error " + exception);
            }
        }
    }
}

