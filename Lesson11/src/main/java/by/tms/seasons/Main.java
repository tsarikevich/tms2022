package by.tms.seasons;

import static by.tms.seasons.Season.*;

public class Main {
    public static void main(String[] args) {
        Season favouriteSeason = WINTER;
        System.out.println(favouriteSeason);
        getFavourite(favouriteSeason);
        System.out.println(favouriteSeason.getDescription());
        favouriteSeason = valueOf("SPRING");
        System.out.println(favouriteSeason);
        System.out.println(favouriteSeason.getDescription());
        favouriteSeason = valueOf("SUMMER");
        System.out.println(favouriteSeason);
        System.out.println(favouriteSeason.getDescription());
        Season.getAllSeasons();
    }

}
