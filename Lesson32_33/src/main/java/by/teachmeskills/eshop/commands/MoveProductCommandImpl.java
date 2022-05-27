package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.domain.Product;
import by.teachmeskills.eshop.domain.ProductStorage;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import lombok.extern.log4j.Log4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

import static by.teachmeskills.eshop.RequestParamsEnum.BUTTON_ACTION;
import static by.teachmeskills.eshop.RequestParamsEnum.CART;
import static by.teachmeskills.eshop.RequestParamsEnum.CART_PRODUCTS;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ONE;
import static by.teachmeskills.eshop.RequestParamsEnum.TOTAL_COST;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

@Log4j
public class MoveProductCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        Cart cart = (Cart) session.getAttribute(CART.getValue());
        User user = (User) session.getAttribute(USER.getValue());
        int product_id = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = ProductStorage.getProductById(product_id);
        String action = request.getParameter(BUTTON_ACTION.getValue());
        switch (action) {
            case "buyProduct" -> {
                cart.addProduct(product);
                log.info("Пользователь с id " + user.getId() + " и логином " + user.getLogin() + " добавил " + product.getName() + " с id " + product_id + " в корзину");
                BigDecimal totalCost = cart.getTotalCost();
                session.setAttribute(TOTAL_COST.getValue(), totalCost);
                session.setAttribute(CART_PRODUCTS.getValue(), cart.getProducts());
                request.setAttribute(PRODUCT_ONE.getValue(), product);
                return PagesPathEnum.PRODUCT_PAGE.getPath();
            }
            case "deleteProduct" -> {
                cart.deleteProduct(product);
                log.info("Пользователь с id " + user.getId() + " и логином " + user.getLogin() + " удалил из корзины" + product.getName() + " с id " + product_id);
                BigDecimal totalCost = cart.getTotalCost();
                session.setAttribute(TOTAL_COST.getValue(), totalCost);
                session.setAttribute(CART_PRODUCTS.getValue(), cart.getProducts());
                return PagesPathEnum.CART_PAGE.getPath();
            }
        }
        log.error("При добавлении/удалении товара пользователем с id " + user.getId() + " и логином " + user.getLogin() + " произошла ошибка");
        return null;
    }
}
