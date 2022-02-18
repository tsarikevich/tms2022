package by.tms.square;

import lombok.Setter;

@Setter
public abstract class Figure {
    private int length;
    private int height;
    private int side;
    private Type type;

    public Figure(int length) {
        this.length = length;
    }

    public Figure(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public Figure(int length, int height, int side) {
        this.length = length;
        this.height = height;
        this.side = side;
    }


    public final void getSquare() {
        if (type == Type.LINE) {
            System.out.println("Линия не имеет площадь");
        } else if (type == Type.RECTANGLE) {
            System.out.println("Площадь прямоугольника - " + (length * height));
        } else if (type == Type.TRIANGLE) {
            double halfPerimeter = (double) (height + length + side) / 2;
            double square = Math.sqrt(halfPerimeter * (halfPerimeter - length) * (halfPerimeter - height) * (halfPerimeter - side));
            System.out.println("Площадь треугольника - " + (square));
        }

    }
}
