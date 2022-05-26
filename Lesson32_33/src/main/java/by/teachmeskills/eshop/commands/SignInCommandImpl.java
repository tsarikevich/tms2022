package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.RequestParamsEnum;
import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.domain.Category;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.domain.UserStorage;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CART;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.domain.CategoryStorage.getCategories;
import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;
import static by.teachmeskills.eshop.utils.Utils.LOGIN;
import static by.teachmeskills.eshop.utils.Utils.PASSWORD;

public class SignInCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        LOGIN = request.getParameter(RequestParamsEnum.LOGIN.getValue());
        PASSWORD = request.getParameter(RequestParamsEnum.PASSWORD.getValue());
        validateParamNotNull(LOGIN);
        validateParamNotNull(PASSWORD);
        User user = new User(LOGIN, PASSWORD);
        return checkReceivedUser(user, request);
    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        if (UserStorage.isUserSuit(user)) {
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            session.setAttribute(CART.getValue(), cart);
            session.setAttribute(USER.getValue(), UserStorage.getEqualUser(user));
            List<Category> categories = getCategories();
            request.setAttribute(CATEGORIES.getValue(), categories);
            return HOME_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
