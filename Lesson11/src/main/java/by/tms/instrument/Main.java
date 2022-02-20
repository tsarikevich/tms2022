package by.tms.instrument;

import java.util.Arrays;
import java.util.Scanner;

import static by.tms.instrument.Instrumental.Type;
import static by.tms.instrument.Instrumental.Type.*;


public class Main {
    public static void main(String[] args) {
        Instrumental[] instruments = {createInstrument(GUITAR), createInstrument(DRUM), createInstrument(TRUMPET)};
        for (Instrumental instrument : instruments) {
            instrument.play();
        }
        System.out.println(Arrays.toString(instruments));
    }


    static Scanner scanner = new Scanner(System.in);

    static Instrumental createInstrument(Type instrument) {
        if (GUITAR.equals(instrument)) {
            System.out.println("Введите количество струн гитары");
            Guitar guitar = new Guitar(scanner.nextInt());
            return guitar;
        } else if (DRUM.equals(instrument)) {
            System.out.println("Введите размер барабана");
            Drum drum = new Drum(scanner.nextInt());
            return drum;
        } else if (TRUMPET.equals(instrument)) {
            System.out.println("Введите диаметр трубы");
            Trumpet trumpet = new Trumpet(scanner.nextInt());
            return trumpet;
        }
        return null;
    }
}

