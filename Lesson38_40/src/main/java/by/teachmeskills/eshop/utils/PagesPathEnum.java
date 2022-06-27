package by.teachmeskills.eshop.utils;

import lombok.Getter;

@Getter
public enum PagesPathEnum {
    HOME_PAGE("home"),
    SIGN_IN_PAGE("signin"),
    REGISTRATION_PAGE("registration"),
    CATEGORY_PAGE("category"),
    PRODUCT_PAGE("product"),
    PROFILE_PAGE("profile"),
    CART_PAGE("cart"),
    SEARCH_PAGE("search");
    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }
}
