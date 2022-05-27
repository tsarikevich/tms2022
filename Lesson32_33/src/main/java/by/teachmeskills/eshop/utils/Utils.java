package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.domain.User;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class Utils {
    public static String LOGIN;
    public static String PASSWORD;

    public static boolean isUserLogIn(User user) {
        if (Optional.ofNullable(user).isPresent()
                && user.getLogin().equals(LOGIN)
                && user.getPassword().equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }

    }
}
