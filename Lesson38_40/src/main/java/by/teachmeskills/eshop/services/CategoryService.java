package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.User;
import org.springframework.web.servlet.ModelAndView;

public interface CategoryService extends BaseService<Category> {
    ModelAndView getAllCategories(User user);
}
