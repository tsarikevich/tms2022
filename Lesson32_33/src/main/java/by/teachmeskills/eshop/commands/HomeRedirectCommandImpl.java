package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Category;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.domain.CategoryStorage.getCategories;
import static by.teachmeskills.eshop.utils.Utils.isUserLogIn;

public class HomeRedirectCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (isUserLogIn(user)) {
            List<Category> categories = getCategories();
            request.setAttribute(CATEGORIES.getValue(), categories);
            return HOME_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
