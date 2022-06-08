package by.teachmeskills.eshop;

import lombok.Getter;

@Getter
public enum RequestParamsEnum {
    USER("user"),
    LOGIN("userLogin"),
    PASSWORD("password"),
    COMMAND("command"),
    CART("cart"),
    SEARCH("search"),
    IMAGES_FROM_SEARCH("foundImages"),
    PRODUCTS_FROM_SEARCH("foundProducts"),
    CATEGORIES("categories"),
    CATEGORIES_IMAGES("categoriesImages"),
    PRODUCTS("products"),
    PRODUCTS_IMAGES("productsImages"),
    CART_PRODUCTS_IMAGES("cartProductsImages"),
    ONE_PRODUCT("oneProduct"),
    ONE_PRODUCT_IMAGES("oneProductImages"),
    ORDERS("orders"),
    ORDER_PRODUCTS_IMAGES("orderProductsImages"),
    PRODUCT_PRICE("price"),
    IMAGE_NAME("imageName"),
    PRODUCT_ID("productId"),
    PRODUCT_NAME("productName"),
    PRODUCT_DESCRIPTION("productDescription"),
    TOTAL_COST("totalCost"),
    CART_PRODUCTS("cartProductsList"),
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
