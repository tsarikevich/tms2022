package by.tms.instrument;

import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor

public class Drum implements Instrumental {

    private int size;

    @Override
    public void play() {
        System.out.println("Играет барабан размером - " + size);
    }
}
