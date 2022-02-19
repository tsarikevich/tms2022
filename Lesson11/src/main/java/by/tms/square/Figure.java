package by.tms.square;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Figure {
    private Type type;
    private int length;

    public Figure(int length) {
        this.length = length;


    }
}
