package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Product;
import by.teachmeskills.eshop.domain.ProductStorage;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ONE;

public class ProductRedirectCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int product_id = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = ProductStorage.getProductById(product_id);
        request.setAttribute(PRODUCT_ONE.getValue(), product);
        return PRODUCT_PAGE.getPath();
    }
}
