package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Order;
import by.teachmeskills.eshop.domain.OrderStorage;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.PROFILE_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.ORDERS;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.Utils.isUserLogIn;

public class ProfileRedirectCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (isUserLogIn(user)) {
            List<Order> orders = OrderStorage.getOrdersByUserId(user.getId());
            request.setAttribute(ORDERS.getValue(), orders);
            return PROFILE_PAGE.getPath();
        }
        return SIGN_IN_PAGE.getPath();
    }
}
