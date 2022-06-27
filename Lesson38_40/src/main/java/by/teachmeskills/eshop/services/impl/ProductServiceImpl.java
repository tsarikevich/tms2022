package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.eshop.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.utils.EshopConstants.REDIRECT_TO_LOGIN_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.CATEGORY_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.SEARCH_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.IMAGES_FROM_SEARCH;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.NAME_CATEGORY;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.ONE_PRODUCT;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.ONE_PRODUCT_IMAGES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCTS;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCTS_FROM_SEARCH;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCTS_IMAGES;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepositoryImpl productRepository;
    private ImageRepositoryImpl imageRepository;

    public ProductServiceImpl(ProductRepositoryImpl productRepository, ImageRepositoryImpl imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public Product create(Product entity) {
        return productRepository.create(entity);
    }

    @Override
    public List<Product> read() {
        return productRepository.read();
    }

    @Override
    public Product update(Product entity) {
        return productRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> getAllForCategory(int categoryId) {
        return null;
    }

    @Override
    public ModelAndView getProductData(User user, int id) {
        if (Optional.ofNullable(user.getLogin()).isPresent()
                && Optional.ofNullable(user.getPassword()).isPresent()
                && Optional.ofNullable(user.getEmail()).isPresent()) {
            ModelMap modelMap = new ModelMap();
            Product product = productRepository.getProductById(id);
            List<Image> productImages = imageRepository.getImagesByProductId(id);
            modelMap.addAttribute(ONE_PRODUCT.getValue(), product);
            modelMap.addAttribute(ONE_PRODUCT_IMAGES.getValue(), productImages);
            return new ModelAndView(PRODUCT_PAGE.getPath(), modelMap);
        } else {
            return new ModelAndView(REDIRECT_TO_LOGIN_PAGE);
        }
    }

    @Override
    public ModelAndView getCategoryProductsData(int id, String nameCategory) {
        ModelMap modelMap = new ModelMap();
        List<Product> categoryProducts = productRepository.getProductsByCategoryId(id);
        List<Image> productsImages = imageRepository.getPrimaryImagesByCategoryId(id);
        modelMap.addAttribute(PRODUCTS.getValue(), categoryProducts);
        modelMap.addAttribute(PRODUCTS_IMAGES.getValue(), productsImages);
        modelMap.addAttribute(NAME_CATEGORY.getValue(), nameCategory);
        return new ModelAndView(CATEGORY_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView findAllProductsByRequest(String request) {
        ModelMap modelMap = new ModelMap();
        List<Product> products = productRepository.findAllProductsByRequest(request);
        List<Image> images = imageRepository.getPrimaryImagesByListProducts(products);
        modelMap.addAttribute(IMAGES_FROM_SEARCH.getValue(), images);
        modelMap.addAttribute(PRODUCTS_FROM_SEARCH.getValue(), products);
        return new ModelAndView(SEARCH_PAGE.getPath(), modelMap);
    }
}
