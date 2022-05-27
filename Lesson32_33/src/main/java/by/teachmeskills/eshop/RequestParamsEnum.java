package by.teachmeskills.eshop;

import lombok.Getter;

@Getter
public enum RequestParamsEnum {
    USER("user"),
    LOGIN("username"),
    PASSWORD("password"),
    COMMAND("command"),
    CART("cart"),
    CATEGORIES("categories"),
    PRODUCTS("products"),
    ORDERS("orders"),
    PRODUCT_PRICE("price"),
    IMAGE_NAME("imageName"),
    PRODUCT_ID("productId"),
    PRODUCT_NAME("productName"),
    PRODUCT_DESCRIPTION("productDescription"),
    TOTAL_COST("totalCost"),
    CART_PRODUCTS("cartProductsList"),
    PRODUCT_ONE("oneProduct"),
    CATEGORY_ID("categoryId"),
    NAME_CATEGORY("nameCategory"),
    NEW_USER_LOGIN("newUsrLogin"),
    NEW_USER_PASSWORD("newUsrPass"),
    NEW_USER_YEAR("brthYear"),
    NEW_USER_MONTH("brthMonth"),
    NEW_USER_DAY("brthDay"),
    NEW_USER_NAME("newUsrName"),
    NEW_USER_SURNAME("newUsrSurname"),
    NEW_USER_EMAIL("newUsrEmail"),
    CHECK_NEW_USER("isNewUserAdd"),
    BUTTON_ACTION("action"),
    USER_LOGIN("userLogin");

    private final String value;

    RequestParamsEnum(String value) {
        this.value = value;
    }
}
