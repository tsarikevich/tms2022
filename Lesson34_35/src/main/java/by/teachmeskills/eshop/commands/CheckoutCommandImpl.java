package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.impl.OrderRepositoryImpl;
import lombok.extern.log4j.Log4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import static by.teachmeskills.eshop.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CART;
import static by.teachmeskills.eshop.RequestParamsEnum.CART_PRODUCTS;
import static by.teachmeskills.eshop.RequestParamsEnum.TOTAL_COST;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

@Log4j
public class CheckoutCommandImpl implements BaseCommand {
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute(USER.getValue());
        Cart cart = (Cart) session.getAttribute(CART.getValue());
        BigDecimal orderPrice = (BigDecimal) session.getAttribute(TOTAL_COST.getValue());
        LocalDateTime date = LocalDateTime.now();
        Map<Product, Integer> products = (Map<Product, Integer>) session.getAttribute(CART_PRODUCTS.getValue());
        Order order = orderRepository.create(Order.builder()
                .price(orderPrice)
                .date(date)
                .userId(user.getId())
                .products(products)
                .build());
        cart.clear();
        session.setAttribute(CART_PRODUCTS.getValue(), cart.getProducts());
        log.info("Пользователь с id " + user.getId() + " и логином " + user.getLogin() + " оформил заказа № " + order.getId());
        return CART_PAGE.getPath();
    }
}
