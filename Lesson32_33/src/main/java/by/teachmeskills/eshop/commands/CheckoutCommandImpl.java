package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Order;
import by.teachmeskills.eshop.domain.OrderStorage;
import by.teachmeskills.eshop.domain.Product;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import lombok.extern.log4j.Log4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.PROFILE_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CART_PRODUCTS;
import static by.teachmeskills.eshop.RequestParamsEnum.ORDERS;
import static by.teachmeskills.eshop.RequestParamsEnum.TOTAL_COST;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

@Log4j
public class CheckoutCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute(USER.getValue());
        List<Product> cartProducts = (List<Product>) session.getAttribute(CART_PRODUCTS.getValue());
        BigDecimal orderPrice = (BigDecimal) session.getAttribute(TOTAL_COST.getValue());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Order order = new Order(orderPrice, date, user.getId(), cartProducts);
        OrderStorage.addNewOrder(order);
        cartProducts.clear();
        session.setAttribute(CART_PRODUCTS.getValue(), cartProducts);
        List<Order> orders = OrderStorage.getOrdersByUserId(user.getId());
        request.setAttribute(ORDERS.getValue(), orders);
        log.info("Пользователь с id " + user.getId() + " и логином " + user.getLogin() + " оформил заказа № " + order.getId());
        return PROFILE_PAGE.getPath();
    }
}
