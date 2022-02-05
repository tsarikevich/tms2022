package by.tms.task2;

public class Main {
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine("ДВС");
        Car.GasTank gasTank = new Car.GasTank(0, 60);
        Car car = new Car(engine, gasTank);
        car.on();
        car.off();
        car.on();
        car.carStarting();
        car.off();
        car.countDistance();
        car.refuleCar();
        car.on();
        car.carStarting();
        car.carStarting();
        car.off();


    }
}
