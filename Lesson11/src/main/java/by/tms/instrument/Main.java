package by.tms.instrument;

import java.util.Arrays;
import java.util.Scanner;

import static by.tms.instrument.Instrumental.Type.*;


public class Main {
    public static void main(String[] args) {
        Instrumental[] instruments = {createInstrument(GUITAR), createInstrument(DRUM), createInstrument(TRUMPET)};
        System.out.println(Arrays.toString(instruments));
    }


    static Scanner scanner = new Scanner(System.in);

    static Instrumental createInstrument(Instrumental.Type instrument) {
        if (Instrumental.Type.GUITAR.equals(instrument)) {
            System.out.println("Введите количество струн гитары");
            Guitar guitar = new Guitar(scanner.nextInt());
            guitar.play();
            return guitar;
        } else if (Instrumental.Type.DRUM.equals(instrument)) {
            System.out.println("Введите размер барабана");
            Drum drum = new Drum(scanner.nextInt());
            drum.play();
            return drum;
        } else if (Instrumental.Type.TRUMPET.equals(instrument)) {
            System.out.println("Введите диаметр трубы");
            Trumpet trumpet = new Trumpet(scanner.nextInt());
            trumpet.play();
            return trumpet;
        }
        return null;
    }
}

