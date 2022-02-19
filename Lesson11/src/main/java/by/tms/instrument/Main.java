package by.tms.instrument;

import java.util.Arrays;

import static by.tms.instrument.Instrumental.Type.*;


public class Main {
    public static void main(String[] args) {
        Instrumental[] instruments = {createInstrument(GUITAR), createInstrument(DRUM), createInstrument(TRUMPET)};
        System.out.println(Arrays.toString(instruments));
    }
}
