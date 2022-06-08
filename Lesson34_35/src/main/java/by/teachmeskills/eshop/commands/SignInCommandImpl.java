package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.RequestParamsEnum;
import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.ImageRepository;
import by.teachmeskills.eshop.repositories.UserRepository;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.UserRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CART;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES_IMAGES;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;

public class SignInCommandImpl implements BaseCommand {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private final ImageRepository imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(RequestParamsEnum.LOGIN.getValue());
        String pass = request.getParameter(RequestParamsEnum.PASSWORD.getValue());
        validateParamNotNull(login);
        validateParamNotNull(pass);
        User user = new User(login, pass);
        return checkReceivedUser(user, request);
    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        if (userRepository.isUserSuitByLoginAndPassword(user)) {
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            session.setAttribute(CART.getValue(), cart);
            session.setAttribute(USER.getValue(), userRepository.getUserFromBaseByLoginAndPassword(user));
            List<Category> categories = categoryRepository.read();
            List<Image> categoriesImages = imageRepository.getAllCategoriesImages();
            request.setAttribute(CATEGORIES.getValue(), categories);
            request.setAttribute(CATEGORIES_IMAGES.getValue(), categoriesImages);
            return HOME_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
