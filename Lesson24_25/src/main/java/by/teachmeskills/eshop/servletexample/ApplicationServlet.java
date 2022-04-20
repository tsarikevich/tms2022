package by.teachmeskills.eshop.servletexample;

import by.teachmeskills.eshop.exceptions.RequestParamNullException;
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

@WebServlet("/login")
public class ApplicationServlet extends HttpServlet {

    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("signin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String pass = req.getParameter("password");
        User user = null;

        try {
            validateParamNotNull(login);
            validateParamNotNull(pass);
            user = new User(ADMIN_LOGIN, ADMIN_PASSWORD);

        } catch (RequestParamNullException e) {
            System.out.println(e.getMessage());
        }

        RequestDispatcher rd = req.getRequestDispatcher(checkReceivedUser(user, req));
        rd.forward(req, resp);

    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        if (user != null
                && request.getParameter("username").equals(ADMIN_LOGIN)
                && request.getParameter("password").equals(ADMIN_PASSWORD)) {
            request.getSession().setAttribute("username", user);
            List<Category> categories = new ArrayList<>();
            Category mobilePhones = new Category("Mobile phones", "mobile.jpg", "mobiles");
            Category laptops = new Category("Laptops", "laptop.jpg", "laptops");
            Category jpsNavigators = new Category("GPS Navigators", "jps_nav.jpg", "navigators");
            Category fridges = new Category("Fridges", "fridge.jpg", "fridges");
            Category car = new Category("Cars", "car.jpg", "cars");
            Category camera = new Category("Cameras", "camera.jpg", "cameras");
            categories.add(mobilePhones);
            categories.add(laptops);
            categories.add(jpsNavigators);
            categories.add(fridges);
            categories.add(car);
            categories.add(camera);

            request.setAttribute("categories", categories);

            return "home.jsp";
        } else {
            return "signin.jsp";
        }
    }
}
