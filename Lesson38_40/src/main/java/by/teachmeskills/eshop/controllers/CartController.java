package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.services.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCT_ID;
import static by.teachmeskills.eshop.utils.EshopConstants.REDIRECT_TO_LOGIN_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.EshopConstants.USER;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ModelAndView openCartPage(@SessionAttribute(SHOPPING_CART) Cart cart,
                                     @SessionAttribute(USER) User user) {
        if (Optional.ofNullable(user.getLogin()).isPresent()
                && Optional.ofNullable(user.getPassword()).isPresent()
                && Optional.ofNullable(user.getEmail()).isPresent()) {
            return cartService.getCartData(cart);
        } else {
            return new ModelAndView(REDIRECT_TO_LOGIN_PAGE);
        }
    }

    @GetMapping("/add")
    public ModelAndView addProductToCart(@RequestParam(PRODUCT_ID) int id, @SessionAttribute(SHOPPING_CART) Cart cart) {
        return cartService.addProductToCart(id, cart);
    }

    @GetMapping("/delete")
    public ModelAndView deleteProductFromCart(@RequestParam(PRODUCT_ID) int id, @SessionAttribute(SHOPPING_CART) Cart cart) {
        return cartService.deleteProductFromCart(id, cart);
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(@SessionAttribute(SHOPPING_CART) Cart cart,
                                 @SessionAttribute(USER) User user) {
        return cartService.checkout(cart, user);
    }
}
