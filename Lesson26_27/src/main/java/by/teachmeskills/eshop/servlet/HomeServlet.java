package by.teachmeskills.eshop.servlet;

import by.teachmeskills.eshop.exceptions.RequestParamNullException;
import by.teachmeskills.eshop.model.Cart;
import by.teachmeskills.eshop.model.Category;
import by.teachmeskills.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;
import static by.teachmeskills.eshop.utils.Utils.*;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("username");
        checkReceivedUser(user, request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        String pass = request.getParameter("password");
        User user;
        Cart cart;
        try {
            validateParamNotNull(login);
            validateParamNotNull(pass);
            user = new User(ADMIN_LOGIN, ADMIN_PASSWORD);
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
            request.getSession().setAttribute("username", user);
            checkReceivedUser(user, request, response);

        } catch (RequestParamNullException e) {
            System.out.println(e.getMessage());
        }

    }

    private void checkReceivedUser(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isUserLogIn(user)) {
            List<Category> categories = new ArrayList<>();
            Category mobilePhones = new Category(1, "Mobile phones", "mobile.jpg");
            Category laptops = new Category(2, "Laptops", "laptop.jpg");
            Category jpsNavigators = new Category(3, "GPS Navigators", "jps_nav.jpg");
            Category fridges = new Category(4, "Fridges", "fridge.jpg");
            Category car = new Category(5, "Cars", "car.jpg");
            Category camera = new Category(6, "Cameras", "camera.jpg");
            categories.add(mobilePhones);
            categories.add(laptops);
            categories.add(jpsNavigators);
            categories.add(fridges);
            categories.add(car);
            categories.add(camera);
            request.setAttribute("categories", categories);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
