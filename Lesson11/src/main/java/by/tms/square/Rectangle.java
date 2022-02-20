package by.tms.square;


public class Rectangle extends Figure implements Computing {
    private int height;

    public Rectangle(int length, int height) {
        super(Type.RECTANGLE, length);
        this.height = height;
    }


    @Override
    public void getSquare() {
        System.out.println("Площадь прямоугольника - " + (getLength() * height));
    }
}

