package by.tms.square;

import lombok.Getter;


@Getter
public abstract class Figure {
    private final Type type;
    private int length;

    public Figure(Type type, int length) {
        this.type = type;
        this.length = length;


    }
}
