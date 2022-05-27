package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Product;
import by.teachmeskills.eshop.domain.ProductStorage;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.CATEGORY_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORY_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.NAME_CATEGORY;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCTS;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.Utils.isUserLogIn;

public class CategoryRedirectCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (isUserLogIn(user)) {
            int category_id = Integer.parseInt(request.getParameter(CATEGORY_ID.getValue()));
            String nameCategory = request.getParameter(NAME_CATEGORY.getValue());
            List<Product> categoryProducts = ProductStorage.getProductsByCategoryId(category_id);
            request.setAttribute(PRODUCTS.getValue(), categoryProducts);
            request.setAttribute(NAME_CATEGORY.getValue(), nameCategory);
            return CATEGORY_PAGE.getPath();
        }
        return SIGN_IN_PAGE.getPath();
    }
}
