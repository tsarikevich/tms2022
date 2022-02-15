package by.tms.space;

import java.util.Random;

public class Shuttle implements IStart {

    @Override
    public boolean preLaunchSystemCheck() {
        Random random = new Random();
        int numberOfCheck = random.nextInt(11);
        System.out.println("Число проверки Шатла= " + numberOfCheck);
        if (numberOfCheck > 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onEngine() {
        System.out.println("Двигатели Шатла запущены. Все системы в норме");
    }

    @Override
    public void start() {
        System.out.println("Старт Шатла");
    }
}
