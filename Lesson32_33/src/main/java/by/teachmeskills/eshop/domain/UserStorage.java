package by.teachmeskills.eshop.domain;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void addNewUser(User user) {
        users.add(user);
    }

    public static boolean isUserInBase(User user) {
        if (users.stream()
                .anyMatch(userInList -> userInList.getLogin().equals(user.getLogin()))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isUserSuit(User user) {
        if (users.stream()
                .anyMatch(userInList -> userInList.getLogin().equals(user.getLogin())
                        && userInList.getPassword().equals(user.getPassword()))) {
            return true;
        } else {
            return false;
        }
    }

    public static User getEqualUser(User user) {
        return users.stream()
                .filter(userInList -> userInList.getLogin().equals(user.getLogin())
                        && userInList.getPassword().equals(user.getPassword()))
                .findFirst()
                .orElse(null);
    }
}
