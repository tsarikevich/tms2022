package by.teachmeskills.eshop;

import lombok.Getter;

@Getter
public enum CommandsEnum {
    HOME_PAGE_COMMAND("start_page"),
    SIGN_IN_COMMAND("sign-in"),
    REGISTRATION_PAGE_COMMAND("registration"),
    CATEGORY_PAGE_COMMAND("category-redirect"),
    PRODUCT_PAGE_COMMAND("redirect-to-product"),
    PROFILE_PAGE_COMMAND("redirect-to-profile"),
    CART_PAGE_COMMAND("redirect-to-shopping-cart"),
    MOVE_PRODUCT("move-product"),
    CHECKOUT_FROM_CART("checkout-from-cart"),
    ADD_NEW_USER_TO_BASE("add-new-user-to-base"),
    LOGOUT_COMMAND("logout"),
    SEARCH_COMMAND("redirect-to-search");
    private final String command;

    CommandsEnum(String command) {
        this.command = command;
    }
}
