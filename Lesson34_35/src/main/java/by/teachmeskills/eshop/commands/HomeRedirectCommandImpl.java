package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.ImageRepository;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES_IMAGES;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

public class HomeRedirectCommandImpl implements BaseCommand {
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private final ImageRepository imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (Optional.ofNullable(user).isPresent()) {
            List<Category> categories = categoryRepository.read();
            List<Image> categoriesImages = imageRepository.getAllCategoriesImages();
            request.setAttribute(CATEGORIES.getValue(), categories);
            request.setAttribute(CATEGORIES_IMAGES.getValue(), categoriesImages);
            return HOME_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
