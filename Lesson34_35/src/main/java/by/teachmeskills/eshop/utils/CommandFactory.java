package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.commands.AddNewUserToBaseCommandImpl;
import by.teachmeskills.eshop.commands.BaseCommand;
import by.teachmeskills.eshop.commands.CartRedirectCommandImpl;
import by.teachmeskills.eshop.commands.CategoryRedirectCommandImpl;
import by.teachmeskills.eshop.commands.CheckoutCommandImpl;
import by.teachmeskills.eshop.commands.HomeRedirectCommandImpl;
import by.teachmeskills.eshop.commands.LogoutCommandImpl;
import by.teachmeskills.eshop.commands.MoveProductCommandImpl;
import by.teachmeskills.eshop.commands.ProductRedirectCommandImpl;
import by.teachmeskills.eshop.commands.ProfileRedirectCommandImpl;
import by.teachmeskills.eshop.commands.RegistrationRedirectCommandImpl;
import by.teachmeskills.eshop.commands.SearchRedirectCommandImpl;
import by.teachmeskills.eshop.commands.SignInCommandImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static by.teachmeskills.eshop.CommandsEnum.ADD_NEW_USER_TO_BASE;
import static by.teachmeskills.eshop.CommandsEnum.CART_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.CATEGORY_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.CHECKOUT_FROM_CART;
import static by.teachmeskills.eshop.CommandsEnum.HOME_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.LOGOUT_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.MOVE_PRODUCT;
import static by.teachmeskills.eshop.CommandsEnum.PRODUCT_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.PROFILE_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.REGISTRATION_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.SEARCH_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.SIGN_IN_COMMAND;
import static by.teachmeskills.eshop.RequestParamsEnum.COMMAND;

public class CommandFactory {
    private static Map<String, BaseCommand> COMMAND_LIST = new HashMap<>();

    static {
        COMMAND_LIST.put(SIGN_IN_COMMAND.getCommand(), new SignInCommandImpl());
        COMMAND_LIST.put(HOME_PAGE_COMMAND.getCommand(), new HomeRedirectCommandImpl());
        COMMAND_LIST.put(CATEGORY_PAGE_COMMAND.getCommand(), new CategoryRedirectCommandImpl());
        COMMAND_LIST.put(PRODUCT_PAGE_COMMAND.getCommand(), new ProductRedirectCommandImpl());
        COMMAND_LIST.put(CART_PAGE_COMMAND.getCommand(), new CartRedirectCommandImpl());
        COMMAND_LIST.put(PROFILE_PAGE_COMMAND.getCommand(), new ProfileRedirectCommandImpl());
        COMMAND_LIST.put(MOVE_PRODUCT.getCommand(), new MoveProductCommandImpl());
        COMMAND_LIST.put(CHECKOUT_FROM_CART.getCommand(), new CheckoutCommandImpl());
        COMMAND_LIST.put(REGISTRATION_PAGE_COMMAND.getCommand(), new RegistrationRedirectCommandImpl());
        COMMAND_LIST.put(ADD_NEW_USER_TO_BASE.getCommand(), new AddNewUserToBaseCommandImpl());
        COMMAND_LIST.put(LOGOUT_COMMAND.getCommand(), new LogoutCommandImpl());
        COMMAND_LIST.put(SEARCH_COMMAND.getCommand(), new SearchRedirectCommandImpl());
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter(COMMAND.getValue());
        System.out.println(commandKey);
        if (Optional.ofNullable(commandKey).isEmpty()) {
            commandKey = SIGN_IN_COMMAND.getCommand();
        }
        return COMMAND_LIST.get(commandKey);
    }
}

