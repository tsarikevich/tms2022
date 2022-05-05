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
import java.util.List;

import static by.teachmeskills.eshop.model.CategoryStorage.getCategories;
import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;
import static by.teachmeskills.eshop.utils.Utils.ADMIN_LOGIN;
import static by.teachmeskills.eshop.utils.Utils.ADMIN_PASSWORD;
import static by.teachmeskills.eshop.utils.Utils.isUserLogIn;


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
            List<Category> categories = getCategories();
            request.setAttribute("categories", categories);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
