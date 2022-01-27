import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    public static void main(String[] args) {
//1) Задача на оператор switch!
//        Рандомно генерируется число От 1 до 7.
//        Если число равно 1, выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
//        Если 6 или 7 – “Выходной”.
        System.out.println("Задача 1: день недели");
        int numberRandom = (int) (Math.random() * 7) + 1;
        switch (numberRandom) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6, 7:
                System.out.println("Выходной");
                break;
            default:
                System.out.println("Вы ввели неккоректную дату");
        }

//2) Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//         сколько амеб будет через 3, 6, 9, 12,..., 24 часа
        System.out.println("Задача 2: Деление клеток амебы");
        int ameba = 1;
        for (int i = 0; i < 24; i += 3) {
            ameba *= 2;
            System.out.print(ameba + " ");
        }
        System.out.println();
//3) В переменную записываем число.
//        Надо вывести на экран сколько в этом числе цифр и положительное оно или отрицательное.
//        Например, Введите число: 5
//        "5 - это положительное число, количество цифр = 1"
        System.out.println("Задча 3: определение свойств чисел");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = scanner.nextInt();
        if (number > 0) {
            System.out.println(number + " - это положительное число, количество цифр = " + getCount(number));
        } else if (number < 0) {
            System.out.println(number + " - это отрицательное число, количество цифр = " + getCount(number));
        } else if (number == 0) {
            System.out.println("Введенное число - 0, количество цифр = 1");
        }

//4) Дано 2 числа, день и месяц рождения. Написать программу, которая определяет знак зодиака человека.
        System.out.println("Задача 4: определение знака зодиака");
        System.out.println("Введите день рождения:");
        int day = scanner.nextInt();
        System.out.println("Введите месяц рождения:");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
                if (0 < day && day <= 20) {
                    System.out.println("Козерог");
                } else if (20 < day && day <= 31) {
                    System.out.println("Водолей");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 2:
                if (0 < day && day <= 19) {
                    System.out.println("Водолей");
                } else if (19 < day && day <= 29) {
                    System.out.println("Рыбы");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 3:
                if (0 < day && day <= 20) {
                    System.out.println("Рыбы");
                } else if (20 < day && day <= 31) {
                    System.out.println("Овен");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 4:
                if (0 < day && day <= 20) {
                    System.out.println("Овен");
                } else if (20 < day && day <= 30) {
                    System.out.println("Телец");
                } else {
                    System.out.println("Вы ввели неккоректный день рождения");
                }
                break;
            case 5:
                if (0 < day && day <= 21) {
                    System.out.println("Телец");
                } else if (21 < day && day <= 31) {
                    System.out.println("Близнецы");
                } else {
                    System.out.println("Вы ввели неккоректный день рождения");
                }
                break;
            case 6:
                if (0 < day && day <= 21) {
                    System.out.println("Близнецы");
                } else if (21 < day && day <= 30) {
                    System.out.println("Рак");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 7:
                if (0 < day && day <= 22) {
                    System.out.println("Рак");
                } else if (22 < day && day <= 31) {
                    System.out.println("Лев");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 8:
                if (0 < day && day <= 21) {
                    System.out.println("Лев");
                } else if (21 < day && day <= 31) {
                    System.out.println("Дева");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 9:
                if (0 < day && day <= 23) {
                    System.out.println("Дева");
                } else if (23 < day && day <= 30) {
                    System.out.println("Весы");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 10:
                if (0 < day && day <= 23) {
                    System.out.println("Весы");
                } else if (23 < day && day <= 31) {
                    System.out.println("Скорпион");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 11:
                if (0 < day && day <= 23) {
                    System.out.println("Скорпион");
                } else if (23 < day && day <= 30) {
                    System.out.println("Стрелец");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            case 12:
                if (0 < day && day <= 22) {
                    System.out.println("Стрелец");
                } else if (22 < day && day <= 30) {
                    System.out.println("Козерог");
                } else {
                    System.out.println("Вы ввели неккоректный день");
                }
                break;
            default:
                System.out.println("Вы ввели неккоректный месяц");
        }


//        Овен (21 марта – 20 апреля)
//        Телец (21 апреля – 21 мая)
//        Близнецы (22 мая – 21 июня)
//        Рак (22 июня – 22 июля)
//        Лев (23 июля – 21 августа)
//        Дева (22 августа – 23 сентября)
//        Весы (24 сентября – 23 октября)
//        Скорпион (24 октября – 23 ноября)
//        Стрелец (23 ноября — 22 декабря)
//        Козерог (23 декабря — 20 января)
//        Водолей (21 января — 19 февраля)
//        Рыбы (20 февраля — 20 марта)
//        Некоторые тесты для проверки задач. Можно также написать свои тесты.
        printArray();
        System.out.println(operation(1));
        System.out.println(operation(0));
        System.out.println(calculateCountOfOddElementsInMatrix(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println("Задача 8: Количество пограммистов");
        countDevs(112);
        countDevs(101);
        countDevs(125);
        countDevs(113);
        foobar(6);
        foobar(10);
        foobar(15);
        printPrimeNumbers();
    }

    private static int getCount(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    /**
     * Необходимо прочитать с консоли значение числа типа int,
     * сделать проверку что если пользователь ввел не положительное число,
     * то вывести ошибку и отправить пользователя вводить заново новое число!
     * далее создать одномерный массив типа int размера прочитанного с консоли
     * далее заполнить массив случайными значениями
     * далее вывести массив на консоль
     */
    private static void printArray() {
        System.out.println("Задача 5: заданный одномерный массив случайных элементов");
        int number;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите положительное число:");
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("Ошибка ввода");
            }
        } while (number <= 0);

        int[] array = new int[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Метод должен выполнять некоторую операцию с int "number" в зависимости от некоторых условий:
     * - if number положительное число, то необходимо number увеличить на 1
     * - if number отрицательное - уменьшить на 2
     * - if number равно 0 , то замените значение number на 10
     * вернуть number после выполнения операций
     */
    public static int operation(int number) {
        System.out.println("Задача 6: number");
        if (number > 0) {
            number++;
        } else if (number < 0) {
            number -= 2;
        } else if (number == 0) {
            number = 10;
        }
        return number;
    }

    /**
     * На вход приходит массив целых чисел типа int
     * Необходимо найти количество нечетных элементов в массиве и вернуть значение в метод main,
     * в котором это значение распечатается на консоль.
     */
    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        System.out.println("Задача 7: Количество нечетных элементов в массиве");
        int count1 = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % 2 != 0) {
                count1++;
            }
        }
        return count1;
    }

    /**
     * На вход приходит число.
     * Вывести в консоль фразу из разряда "_COUNT_ программистов",
     * заменить _COUNT_ на число которое пришло на вход в метод и заменить окончание в слове "программистов" на
     * уместное с точки зрения русского языка.
     * Пример: 1 программист, 42 программиста, 50 программистов
     *
     * @param count - количество программистов
     */
    public static void countDevs(int count) {
        if (count % 10 == 1 && count % 100 != 11) {
            System.out.println(count + " программист");
        } else if (count % 10 == 2 && count % 100 != 12
                || count % 10 == 3 && count % 100 != 13
                || count % 10 == 4 && count % 100 != 14) {
            System.out.println(count + " программиста");
        } else {
            System.out.println(count + " программистов");
        }
    }

    /**
     * Метод должен выводить разные строки в консоли в зависимости от некоторых условий:
     * - если остаток от деления на 3 равен нулю - выведите "foo" (example of number - 6)
     * - если остаток от деления на 5 равен нулю - вывести "bar" (example of number - 10)
     * - если остаток от деления на 3 и 5 равен нулю 0 ,то вывести "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        System.out.println("Задача 9: foo or bar or foobar");
        if (number % 5 == 0 && number % 3 == 0) {
            System.out.println("foobar");
        } else if (number % 3 == 0) {
            System.out.println("foo");
        } else if (number % 5 == 0) {
            System.out.println("bar");
        } else {
            System.out.println("Число не попадает по условие задачи");
        }
    }

    /**
     * Задача со звездочкой!
     * Метод должен печатать все простые числа <1000
     * что такое просто число (https://www.webmath.ru/poleznoe/formules_18_5.php)
     */
    public static void printPrimeNumbers() {
        System.out.println("Задача 10: простые числа");
        int[] array1 = new int[998];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 2;
            for (int j = 2; j < 1000; j++) {
                if (array1[i] % j == 0 && array1[i] != j) {
                    array1[i] = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != 0) {
                System.out.print(array1[i] + " ");
            }
        }
    }
}

