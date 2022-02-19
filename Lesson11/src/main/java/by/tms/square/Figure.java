package by.tms.square;


public abstract class Figure {
    private int length;
    private final int height;
    private final int side;
    private final Type type;

    public Figure(int length) {
        this.length = length;
        this.height = 0;
        this.side = 0;
        this.type = Type.LINE;
    }

    public Figure(int length, int height) {
        this.length = length;
        this.height = height;
        this.side = 0;
        this.type = Type.RECTANGLE;
    }

    public Figure(int length, int height, int side) {
        this.length = length;
        this.height = height;
        this.side = side;
        this.type = Type.TRIANGLE;
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
