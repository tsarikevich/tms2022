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

import static by.teachmeskills.eshop.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.ONE_PRODUCT;
import static by.teachmeskills.eshop.RequestParamsEnum.ONE_PRODUCT_IMAGES;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

public class ProductRedirectCommandImpl implements BaseCommand {
    private final ProductRepository productRepository = new ProductRepositoryImpl();
    private final ImageRepository imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (Optional.ofNullable(user).isPresent()) {
            int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
            Product product = productRepository.getProductById(productId);
            List<Image> images = imageRepository.getImagesByProductId(productId);
            request.setAttribute(ONE_PRODUCT_IMAGES.getValue(), images);
            request.setAttribute(ONE_PRODUCT.getValue(), product);
            return PRODUCT_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
