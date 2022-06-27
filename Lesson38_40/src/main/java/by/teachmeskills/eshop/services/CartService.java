package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.OrderRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.utils.EshopConstants.REDIRECT_TO_CART_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.REDIRECT_TO_LOGIN_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.REDIRECT_TO_PRODUCT_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.REDIRECT_TO_PROFILE_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CART_PRODUCTS;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CART_PRODUCTS_IMAGES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.ONE_PRODUCT;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.ONE_PRODUCT_IMAGES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.TOTAL_COST;

@Service
public class CartService {
    private final ProductRepositoryImpl productRepository;
    private final ImageRepositoryImpl imageRepository;
    private final OrderRepositoryImpl orderRepository;

    public CartService(ProductRepositoryImpl productRepository, ImageRepositoryImpl imageRepository, OrderRepositoryImpl orderRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.orderRepository = orderRepository;
    }

    public ModelAndView addProductToCart(int productId, Cart cart) {
        ModelMap modelMap = new ModelMap();
        Product product = productRepository.getProductById(productId);
        List<Image> productImages = imageRepository.getImagesByProductId(productId);
        cart.addProduct(product);
        modelMap.addAttribute(ONE_PRODUCT.getValue(), product);
        modelMap.addAttribute(ONE_PRODUCT_IMAGES.getValue(), productImages);
        return new ModelAndView(REDIRECT_TO_PRODUCT_PAGE + "/" + productId, modelMap);
    }

    public ModelAndView deleteProductFromCart(int productId, Cart cart) {
        Product product = productRepository.getProductById(productId);
        cart.deleteProduct(product);
        return new ModelAndView(REDIRECT_TO_CART_PAGE);
    }

    public ModelAndView getCartData(Cart cart, User user) {
        if (Optional.ofNullable(user.getLogin()).isPresent()
                && Optional.ofNullable(user.getPassword()).isPresent()
                && Optional.ofNullable(user.getEmail()).isPresent()) {
            ModelMap modelMap = new ModelMap();
            List<Image> cartProductsImages = imageRepository.getPrimaryImagesByListProducts(cart.getListProducts());
            modelMap.addAttribute(CART_PRODUCTS.getValue(), cart.getProducts());
            modelMap.addAttribute(TOTAL_COST.getValue(), cart.getTotalPrice());
            modelMap.addAttribute(CART_PRODUCTS_IMAGES.getValue(), cartProductsImages);
            return new ModelAndView(CART_PAGE.getPath(), modelMap);
        } else {
            return new ModelAndView(REDIRECT_TO_LOGIN_PAGE);
        }
    }

    public ModelAndView checkout(Cart cart, User user) {
        orderRepository.create(Order.builder()
                .price(cart.getTotalPrice())
                .date(LocalDateTime.now())
                .userId(user.getId())
                .products(cart.getProducts())
                .build());
        cart.clear();
        return new ModelAndView(REDIRECT_TO_PROFILE_PAGE);
    }

}
