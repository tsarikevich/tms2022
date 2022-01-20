import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        //Задачи:
        //1) Используя тип данных char и операцию инкремента вывести на консоль все буквы английского алфавита
        System.out.println("Задача 1: Вывод на консоль букв английского алфавита:");
        for (char a = 'A'; a <= 'Z'; a++) {
            if (a == 'Z') {
                System.out.print(a + "\n"); //перевод каретки в консоли на новую строку для новой задачи в консоле
            } else {
                System.out.print(a + " ");
            }
        }
        // System.out.println(); // пропуск строки для следующей задаче в консоле
        //2)Проверка четности числа
        //Создать программу, которая будет сообщать, является ли целое число, введённое пользователем,
        // чётным или нет. Ввод числа осуществлять с помощью класса Scanner.
        // Если пользователь введёт не целое число, то сообщать ему об ошибке.
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Задача 2: Введите число для проверки четности:");
        if (scan1.hasNextInt()) {
            int number = scan1.nextInt();
            if (number % 2 == 0) {
                System.out.println("Введенное число - чётное");
            } else {
                System.out.println("Введенное число - нечётное");
            }
        } else {
            System.out.println("Введенное число - не целое ");
        }
        //3) Меньшее по модулю число
        //Создать программу, которая будет выводить на экран меньшее по модулю из трёх введённых
        // пользователем вещественных чисел с консоли.
        Scanner scan2 = new Scanner(System.in);
        double[] array1 = new double[3];
        System.out.println("Задача 3: Введите три числа для определения меньшего по модулю");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Math.abs(scan2.nextDouble());
        }
        double min = array1[0];
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < min) {
                min = array1[i];
            }
        }
        System.out.print(min);
    }
    //4) На некотором предприятии инженер Петров создал устройство, на табло которого показывается количество секунд,
    // оставшихся до конца рабочего дня. Когда рабочий день начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов),
    // когда времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа), а когда наступает 17 часов — на табло отображается «0»
    // (т.е. рабочий день закончился).
    //Программист Иванов заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня в секундах.
    // Иванов вызвался помочь сотрудницам и написать программу, которая вместо секунд будет выводить на табло понятные фразы с информацией о том,
    // сколько полных часов осталось до конца рабочего дня. Например: «осталось 7 часов», «осталось 4 часа», «остался 1 час», «осталось менее часа».
    //Итак, в переменную n должно записываться случайное (на время тестирования программы) целое число из [0;28800],
    // далее оно должно выводиться на экран (для Петрова) и на следующей строке (для сотрудниц) должна
    // выводиться фраза о количестве полных часов, содержащихся в n секундах.

    /* double max = array1[0];
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] > max) {
                max = array1[i];
            }
        }*/

    //5) Необходимо написать программу, которая будет выводить на консоль таблицу приведения типов!
//              byte	short	char	int 	long	float	double	boolean
//    byte
//    short
//    char
//    int
//    long
//    float
//    double
//    boolean
//
//    На пересечении напишите следующие фразы:
//    ня (неявное) – если преобразование происходит автоматически,
//    я (явное) – если нужно использовать явное преобразование,
//    х – если преобразование невозможно,
//    т  - если преобразование тождественно.
//    Внимание! используйте System.out.printLn

    /**
     * 6) Метод должен вернуть среднее значение из массива чисел
     * (необходимо сумму всех элеменов массива разделить на длину массива)
     * <p>
     * Example:
     * array = {1,2,3,4,5}
     * Метод должен return 3.0
     */
    public static double average(int[] array) {
        return 0;
    }

    /**
     * 7) Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод возвращает 10
     **/
    public static int max(int[] array) {
        return 0;
    }

}
