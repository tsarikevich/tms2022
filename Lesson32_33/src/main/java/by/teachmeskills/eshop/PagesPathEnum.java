package by.teachmeskills.eshop;

import lombok.Getter;

@Getter
public enum PagesPathEnum {
    HOME_PAGE("home.jsp"),
    SIGN_IN_PAGE("signin.jsp"),
    REGISTRATION_PAGE("registration.jsp"),
    CATEGORY_PAGE("category.jsp"),
    PRODUCT_PAGE("product.jsp"),
    PROFILE_PAGE("profile.jsp"),
    CART_PAGE("cart.jsp");
    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }
}
