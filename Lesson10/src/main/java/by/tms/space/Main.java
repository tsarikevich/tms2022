package by.tms.space;

public class Main {
    public static void main(String[] args) {
        Cosmodrome cosmodrome = new Cosmodrome();
        cosmodrome.start(new Shuttle());
        cosmodrome.start(new SpaceX());
    }
}
