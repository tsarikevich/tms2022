package by.teachmeskills.eshop.commands;


import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.ImageRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.PagesPathEnum.SEARCH_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.IMAGES_FROM_SEARCH;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCTS_FROM_SEARCH;
import static by.teachmeskills.eshop.RequestParamsEnum.SEARCH;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

public class SearchRedirectCommandImpl implements BaseCommand {
    private final ProductRepository productRepository = new ProductRepositoryImpl();
    private final ImageRepository imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (Optional.ofNullable(user).isPresent()) {
            String requestFromUser = request.getParameter(SEARCH.getValue());
            List<Product> products = productRepository.findAllProductsByRequest(requestFromUser);
            List<Image> images = imageRepository.getPrimaryImagesByListProducts(products);
            request.setAttribute(IMAGES_FROM_SEARCH.getValue(), images);
            request.setAttribute(PRODUCTS_FROM_SEARCH.getValue(), products);
            return SEARCH_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}