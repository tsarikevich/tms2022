package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.ImageRepository;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CART;
import static by.teachmeskills.eshop.RequestParamsEnum.CART_PRODUCTS_IMAGES;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

public class CartRedirectCommandImpl implements BaseCommand {
    private ImageRepository imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (Optional.ofNullable(user).isPresent()) {
            HttpSession session = request.getSession(false);
            Cart cart = (Cart) session.getAttribute(CART.getValue());
            List<Image> images = imageRepository.getPrimaryImagesByListProducts(cart.getListProducts());
            session.setAttribute(CART_PRODUCTS_IMAGES.getValue(), images);
            return CART_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
