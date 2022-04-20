package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.model.User;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class Utils {
    public static boolean isUserLogIn(User user) {
        if (Optional.ofNullable(user).isPresent() && user.getName().equals("admin") && user.getPassword().equals("admin")) {
            return true;
        } else {
            return false;
        }
    }
}
