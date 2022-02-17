package by.tms.instrument;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Trumpet implements Instrumental {

    private int diameter;

    @Override
    public void play() {
        System.out.println("Играет труба с диаметром - " + diameter);
    }
}
