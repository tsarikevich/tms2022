package by.tms.space;


public class Cosmodrome {

    void start(IStart iStart) {
        if (!iStart.preLaunchSystemCheck()) {
            System.out.println("Предстартовая проверка провалена");
        } else {
            System.out.println("Предстартовая проверка прошла успешно");
            System.out.println("Обратный отсчёт для запуска начался:");
            for (int i = 10; i >= 0; i--) {
                System.out.print(i + "...");
            }
            iStart.onEngine();
            iStart.start();
        }
    }


}
