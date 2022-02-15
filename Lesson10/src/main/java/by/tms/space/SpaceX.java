package by.tms.space;

import java.util.Scanner;

public class SpaceX implements IStart {
    @Override
    public boolean preLaunchSystemCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для предстартовой проверки SpaceX:");
        int numberOfCheck = scanner.nextInt();

        if (numberOfCheck > 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onEngine() {
        System.out.println("Двигатели SpaceX запущены. Все системы в норме");

    }

    @Override
    public void start() {
        System.out.println("Старт SpaceX");
    }
}
