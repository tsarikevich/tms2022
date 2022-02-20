package by.tms.square;


public class Triangle extends Figure implements Computing {
    private int height;
    private int side;

    public Triangle(int length, int height, int side) {
        super(Type.TRIANGLE, length);
        this.height = height;
        this.side = side;
    }

    @Override
    public void getSquare() {
        double halfPerimeter = (double) (height + getLength() + side) / 2;
        double square = Math.sqrt(halfPerimeter * (halfPerimeter - getLength()) * (halfPerimeter - height) * (halfPerimeter - side));
        System.out.println("Площадь треугольника - " + (square));
    }
}
