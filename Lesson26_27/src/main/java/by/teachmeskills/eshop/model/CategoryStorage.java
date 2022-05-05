package by.teachmeskills.eshop.model;

import java.util.Arrays;
import java.util.List;

public class CategoryStorage {
    private static List<Category> categories = Arrays.asList(
            new Category(1, "Mobile phones", "mobile.jpg"),
            new Category(2, "Laptops", "laptop.jpg"),
            new Category(3, "GPS Navigators", "jps_nav.jpg"),
            new Category(4, "Fridges", "fridge.jpg"),
            new Category(5, "Cars", "car.jpg"),
            new Category(6, "Cameras", "camera.jpg")
    );

    public static List<Category> getCategories() {
        return categories;
    }
}
