package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.User;

public interface UserRepository extends BaseRepository<User> {


    boolean isUserSuitByLoginAndPassword(User user);

    User getUserFromBaseByLoginAndPassword(User user);

    User getUserFromBaseByLogin(User user);

    User getUserById(int id);
}
