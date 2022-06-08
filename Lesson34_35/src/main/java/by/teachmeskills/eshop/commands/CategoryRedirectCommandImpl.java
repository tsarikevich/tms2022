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

import static by.teachmeskills.eshop.PagesPathEnum.CATEGORY_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORY_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.NAME_CATEGORY;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCTS;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCTS_IMAGES;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

public class CategoryRedirectCommandImpl implements BaseCommand {
    private final ProductRepository productRepository = new ProductRepositoryImpl();
    private final ImageRepository imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (Optional.ofNullable(user).isPresent()) {
            int categoryId = Integer.parseInt(request.getParameter(CATEGORY_ID.getValue()));
            String nameCategory = request.getParameter(NAME_CATEGORY.getValue());
            List<Product> categoryProducts = productRepository.getProductsByCategoryId(categoryId);
            List<Image> imagesProducts = imageRepository.getPrimaryImagesByCategoryId(categoryId);
            request.setAttribute(PRODUCTS_IMAGES.getValue(), imagesProducts);
            request.setAttribute(PRODUCTS.getValue(), categoryProducts);
            request.setAttribute(NAME_CATEGORY.getValue(), nameCategory);
            return CATEGORY_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
