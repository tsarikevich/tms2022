package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.AuthorizationException;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.UserRepositoryImpl;
import by.teachmeskills.eshop.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.utils.EshopConstants.USER;
import static by.teachmeskills.eshop.utils.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.PROFILE_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.REGISTRATION_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORIES_IMAGES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CHECK_NEW_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.ORDERS;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.ORDER_PRODUCTS_IMAGES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.USER_LOGIN;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;
    private final CategoryRepositoryImpl categoryRepository;
    private final ImageRepositoryImpl imageRepository;
    private final OrderRepository orderRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository, CategoryRepositoryImpl categoryRepository, ImageRepositoryImpl imageRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public User create(User entity) {
        return userRepository.create(entity);
    }

    @Override
    public List<User> read() {
        return userRepository.read();
    }

    @Override
    public User update(User entity) {
        return userRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public ModelAndView authenticate(User user) throws AuthorizationException {
        ModelAndView modelAndView = new ModelAndView();
        if (Optional.ofNullable(user).isPresent()
                && Optional.ofNullable(user.getLogin()).isPresent()
                && Optional.ofNullable(user.getPassword()).isPresent()) {
            User loggedUser = userRepository.getUserFromBaseByLoginAndPassword(
                    User.builder()
                            .login(user.getLogin())
                            .password(user.getPassword())
                            .build()
            );
            if (Optional.ofNullable(loggedUser).isPresent()) {
                ModelMap modelMap = new ModelMap();
                List<Category> categories = categoryRepository.read();
                List<Image> categoriesImages = imageRepository.getAllCategoriesImages();
                modelMap.addAttribute(CATEGORIES.getValue(), categories);
                modelMap.addAttribute(CATEGORIES_IMAGES.getValue(), categoriesImages);
                modelMap.addAttribute(USER, loggedUser);
                modelAndView.setViewName(HOME_PAGE.getPath());
                modelAndView.addAllObjects(modelMap);
            } else {
                throw new AuthorizationException("User is not authorized! Please, try again.");
            }
        }
        return modelAndView;
    }

    @Override
    public ModelAndView registration(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (Optional.ofNullable(user).isPresent()
                && Optional.ofNullable(user.getLogin()).isPresent()
                && Optional.ofNullable(user.getName()).isPresent()
                && Optional.ofNullable(user.getSurname()).isPresent()
                && Optional.ofNullable(user.getBirthDate()).isPresent()
                && Optional.ofNullable(user.getEmail()).isPresent()
                && Optional.ofNullable(user.getPassword()).isPresent()) {
            if (isUserInBase(user)) {
                ModelMap modelMap = new ModelMap();
                modelMap.addAttribute(CHECK_NEW_USER.getValue(), false);
                modelMap.addAttribute(USER_LOGIN.getValue(), user);
                modelAndView.setViewName(REGISTRATION_PAGE.getPath());
                modelAndView.addAllObjects(modelMap);
            } else {
                create(user);
                modelAndView.addObject(CHECK_NEW_USER.getValue(), true);
                modelAndView.setViewName(SIGN_IN_PAGE.getPath());
            }
        } else {
            modelAndView.addObject(CHECK_NEW_USER.getValue(), true);
            modelAndView.setViewName(REGISTRATION_PAGE.getPath());
        }
        return modelAndView;
    }

    @Override
    public ModelAndView showProfile(User user) {
        ModelMap modelMap = new ModelMap();
        List<Image> images = imageRepository.getAllOrderPrimaryImagesByUserId(user.getId());
        List<Order> orders = orderRepository.getOrdersByUserId(user.getId());
        modelMap.addAttribute(ORDER_PRODUCTS_IMAGES.getValue(), images);
        modelMap.addAttribute(ORDERS.getValue(), orders);
        return new ModelAndView(PROFILE_PAGE.getPath(), modelMap);
    }

    private boolean isUserInBase(User user) {
        User userFromBase = userRepository.getUserFromBaseByLogin(user);
        return Optional.ofNullable(userFromBase).isPresent();
    }
}
