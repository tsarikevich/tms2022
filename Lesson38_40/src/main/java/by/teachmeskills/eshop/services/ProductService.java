package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.Product;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    List<Product> getAllForCategory(int categoryId);

    ModelAndView getProductData(int id);

    ModelAndView getCategoryProductsData(int id, String nameCategory);

    ModelAndView findAllProductsByRequest(String request);
}
