package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.AuthorizationException;
import org.springframework.web.servlet.ModelAndView;

public interface UserService extends BaseService<User> {
    ModelAndView authenticate(User user) throws AuthorizationException;

    ModelAndView registration(User user);

    ModelAndView showProfile(User user);
}
