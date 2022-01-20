import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int count=0;
        System.out.println("Введите 5 чисел");
        Scanner c = new Scanner(System.in);
        for (int b = 0; b < 5; b++) {
            int a = c.nextInt();
            if (a > 0) {
                count++;
            }
        }
        System.out.println("Количество положительных чисел равно" + " " + count);
    }
}
