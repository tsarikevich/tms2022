import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        System.out.print("Задача 1: произведение без *");
        summ(3, 4);

        System.out.println("Задача 2: рисование");
        String[][] array = {{" ", " ", " ", "*"}, {" ", " ", "*", "*"}, {" ", "*", "*", "*"}, {"*", "*", "*", "*"}};
        String[][] array1 = {{"*", "*", "*", "*"}, {" ", "*", "*", "*"}, {" ", " ", "*", "*"}, {" ", " ", " ", "*"}};
        String[][] array2 = {{"*", " ", " ", " "}, {"*", "*", " ", " "}, {"*", "*", "*", " "}, {"*", "*", "*", "*"}};
        String[][] array3 = {{"*", "*", "*", "*"}, {"*", "*", "*", " "}, {"*", "*", " ", " "}, {"*", " ", " ", " "}};
        drawTriangle(array);
        drawTriangle(array1);
        drawTriangle(array2);
        drawTriangle(array3);

        System.out.println("Задача 3: нечетный массив в обратном порядке");
        int sizeArray = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                sizeArray++;
            }
        }
        int[] arrayNumber = new int[sizeArray];
        for (int i = 0, b = 0; i < 100; i++) {
            if (i % 2 != 0) {
                arrayNumber[b] = i;
                b++;
            }
        }
        System.out.println(Arrays.toString(arrayNumber));
        for (int i = 0, b = 0; i < arrayNumber.length / 2; i++) {
            int temp = arrayNumber[i];
            arrayNumber[i] = arrayNumber[arrayNumber.length - i - 1];
            arrayNumber[arrayNumber.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(arrayNumber));

        System.out.println("Задача 4: рандомный массив с последним максимальным числом по индексу");
        int[] mass = new int[12];
        Random random = new Random();
        int max = mass[0];
        int index = 0;
        for (int i = 0, j = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(16);
            if (max <= mass[i]) {
                max = mass[i];
                index = i;
            }
        }
        System.out.println(Arrays.toString(mass));
        System.out.println("Максимальный элемент массива = " + max + ", индекс его последнего вхождения в массив = " + index);

        System.out.println("Задача 5: рандомный массив с заменой чисел по нечетным индексам на ноль");
        int[] array4 = new int[20];
        for (int i = 0; i < array4.length; i++) {
            array4[i] = random.nextInt(21);
        }
        System.out.println(Arrays.toString(array4));
        for (int i = 0; i < array4.length; i++) {
            if (i % 2 != 0) {
                array4[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array4));

        System.out.println("Задача 6: максимальный элемент в массиве поменять местами с нулевым элементом");
        int[] array5 = {4, 5, 0, 23, 77, 0, 8, 9, 101, 2};
        int max1 = array5[0];
        int index1 = 0;
        for (int i = 0; i < array5.length; i++) {
            if (max1 < array5[i]) {
                max1 = array5[i];
                index1 = i;
            }
        }
        System.out.println(Arrays.toString(array5));
        int temp = array5[0];
        array5[0] = array5[index1];
        array5[index1] = temp;
        System.out.println(Arrays.toString(array5));

        System.out.println("Задача 7: повторяющиеся элементы в массиве");
        int[] array6 = {0, 3, 46, 3, 2, 1, 2, 3};
        for (int i = 0; i < array6.length - 1; i++) {
            for (int j = i + 1; j < array6.length; j++) {
                if ((array6[i] == array6[j])) {

                    System.out.print(array6[j] + " ");
                }

            }
        }

        System.out.println(Arrays.toString(array6));

        System.out.println("Задача 8: транспонирование матрицы");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во строк матрицы");
        int i = scanner.nextInt();
        System.out.println("Введите кол-во столбцов матрицы");
        int j = scanner.nextInt();
        int[][] arraySquare = new int[i][j];
        for (int k = 0; k < arraySquare.length; k++) {
            for (int l = 0; l < arraySquare[k].length; l++) {
                arraySquare[k][l] = random.nextInt(51);
                System.out.printf("%5d", arraySquare[k][l]);
            }
            System.out.println();
        }
        System.out.println();
        for (int k = 0; k < arraySquare.length; k++) {
            for (int l = 0; l < arraySquare[k].length; l++) {
                System.out.printf("%5d", arraySquare[l][k]);
            }
            System.out.println();
        }

        System.out.println("Задача 9: Сумма элементов двумерного массива по диагонали");
        calculateSumOfDiagonalElements();

        System.out.println("Задача 10: Массив из +,-,*");
        printMatrix();
    }


    private static void summ(int a, int b) {
        System.out.println();
        int[][] x = new int[a][b];
        int p = 0;
        for (int[] hod1 : x) {
            for (int hod2 : hod1) {
                p++;
            }
        }
        System.out.println(p);
    }

    private static void drawTriangle(String[][] array) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

//        Задачи:

//        1) Напишите реализацию метода summ(int a, int b), вычисляющий a*b, не пользуясь операцией
//        умножения, где a и b целые числа, вызовите метод summ  в методе main и распечатайте на консоль.

//        2) Дан двухмерный массив размерностью 4 на 4, необходимо нарисовать четыре треугольника вида

//        a)                  b)
//              *        *
//            * *        * *
//          * * *        * * *
//        * * * *        * * * *
//
//        c)                  d)
//        * * * *        * * * *
//          * * *        * * *
//            * *        * *
//              *        *


//        3) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
//        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).

//        4) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
//        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
//        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 10

//        5) Создайте массив размера 20, заполните его случайными целыми чиселами из отрезка от 0 до 20.
//        Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
//        Снова выведете массив на экран на отдельной строке.

//        6) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом

//        7) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
//        Пример: {0,3,46,3,2,1,2}
//        Массив имеет повторяющиеся элементы 3, 2
//        Пример: {0,34,46,31,20,1,28}
//        Массив не имеет повторяющихся элементов

//        8) Создаём квадратную матрицу, размер вводим с клавиатуры.
//        Заполняем случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде матрицы).
//        Далее необходимо транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
//        Пример:
//
//          1 2 3 4      1 6 3 1
//          6 7 8 9      2 7 3 5
//          3 3 4 5      3 8 4 6
//          1 5 6 7      4 9 5 7


    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */
    public static void calculateSumOfDiagonalElements() {
        int[][] array = new int[4][4];
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(100);
                System.out.printf("%5d", array[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < array.length; i++) {
            count = count + array[i][i];
        }
        System.out.println("Сумма элементов по диагонали = " + count);
    }


    /**
     * Шаги по реализации:
     * - Прочитать два int из консоли
     * - Создайте двумерный массив int (используйте целые числа, которые вы читаете по высоте и ширине консоли)
     * - Заполнить массив случайными значениями (до 100)
     * - Вывести в консоль матрицу заданного размера, но:
     * - Если остаток от деления элемента массива на 3 равен нулю - выведите знак "+" вместо значения элемента массива.
     * - Если остаток от деления элемента массива на 7 равен нулю - выведите знак "-" вместо значения элемента массива.
     * - В противном случае выведите "*"
     * <p>
     * Example:
     * - Значения с консоли - 2 и 3
     * - Массив будет выглядеть так (значения будут разными, потому что он случайный)
     * 6 11 123
     * 1 14 21
     * - Для этого значения вывод в консоли должен быть:
     * <p>
     * + * *
     * * - +
     * <p>
     * Обратите внимание, что 21% 3 == 0 и 21% 7 = 0, но выводить надо не +-, а +
     */
    public static void printMatrix() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введите количество строк для массива");
        int i = scanner.nextInt();
        System.out.println("Введите количество столбцов для массива");
        int j = scanner.nextInt();
        int[][] array = new int[i][j];
        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {
                array[k][l] = random.nextInt(22);
                System.out.print(array[k][l] + "\t");
            }
            System.out.println();
        }
        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {
                if ((array[k][l] % 3 != 0 && array[k][l] % 7 != 0) || (array[k][l] % 3 == 0 && array[k][l] % 7 == 0)) {
                    System.out.print("*" + "\t");
                } else if (array[k][l] % 3 == 0) {
                    System.out.print("+" + "\t");
                } else if (array[k][l] % 7 == 0) {
                    System.out.print("-" + "\t");
                }

            }
            System.out.println();
        }
    }
}


