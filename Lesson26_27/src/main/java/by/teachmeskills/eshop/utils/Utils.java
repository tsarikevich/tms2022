package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.model.User;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class Utils {
    public static final String ADMIN_LOGIN = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    public static boolean isUserLogIn(User user) {
        if (Optional.ofNullable(user).isPresent()
                && user.getName().equals(ADMIN_LOGIN)
                && user.getPassword().equals(ADMIN_PASSWORD)) {
            return true;
        } else {
            return false;
        }

    }
}
