package by.tms.instrument;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor

public class Guitar implements Instrumental {

    private int numbersOfStrings;

    @Override
    public void play() {
        System.out.println("Играет гитара с количеством струн - " + numbersOfStrings);
    }
}
