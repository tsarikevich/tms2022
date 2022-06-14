package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.ImageRepository;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.OrderRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.PagesPathEnum.PROFILE_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.ORDERS;
import static by.teachmeskills.eshop.RequestParamsEnum.ORDER_PRODUCTS_IMAGES;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

public class ProfileRedirectCommandImpl implements BaseCommand {
    private final ImageRepository imageRepository = new ImageRepositoryImpl();
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (Optional.ofNullable(user).isPresent()) {
            List<Image> images = imageRepository.getAllOrderPrimaryImagesByUserId(user.getId());
            List<Order> orders = orderRepository.getOrdersByUserId(user.getId());
            request.setAttribute(ORDER_PRODUCTS_IMAGES.getValue(), images);
            request.setAttribute(ORDERS.getValue(), orders);
            return PROFILE_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
