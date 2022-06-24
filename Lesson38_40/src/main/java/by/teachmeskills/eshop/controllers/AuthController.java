package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.AuthorizationException;
import by.teachmeskills.eshop.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.EshopConstants.USER;
import static by.teachmeskills.eshop.utils.PagesPathEnum.SIGN_IN_PAGE;

@RestController
@SessionAttributes({USER, SHOPPING_CART})
@RequestMapping("/login")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView openLoginPage() {
        return new ModelAndView(SIGN_IN_PAGE.getPath());
    }

    @PostMapping
    public ModelAndView login(@ModelAttribute(USER) User user) throws AuthorizationException {
        return userService.authenticate(user);
    }

    @ModelAttribute(USER)
    public User setUpUserForm() {
        return new User();
    }

    @ModelAttribute(SHOPPING_CART)
    public Cart shoppingCart() {
        return new Cart();
    }
}
