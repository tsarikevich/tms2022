package by.tms.square;

/**
 * Задача5*(звездочка)
 * Используя перечисления(enum), реализовать программу по вычислению площади фигуры (метод getSquare).
 * Создать классы Фигура, Линия, Треугольник, Прямоугольник. Можно пользоваться интерфейсами, при необходимости!
 * Если у фигуры нельзя вычислить площадь, то метод не должен быть реализован в этом классе.
 * Добавить фигуры в массив, пробежать по массиву и вызвать метод getSquare.
 * Внимание!!! пользоваться instanceof НЕЛЬЗЯ, тут нужно применить перечисления.
 */
public class Main {
    public static void main(String[] args) {
        Figure line = new Line(5);
        Figure rectangle = new Rectangle(5, 6);
        Figure rectangle1 = new Rectangle(7, 8);
        Figure triangle = new Triangle(5, 6, 7);
        Triangle triangle1 = new Triangle(2, 3, 4);
        Figure[] figures = {rectangle, line, triangle, rectangle1, triangle1};
        for (Figure figure : figures) {
            figure.getSquare();
        }
        triangle1.getSquare();
    }
}
