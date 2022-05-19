package by.teachmeskills.eshop.servlet;

import by.teachmeskills.eshop.exceptions.RequestParamNullException;
import by.teachmeskills.eshop.model.Cart;
import by.teachmeskills.eshop.model.Category;
import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.model.UserStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.model.CategoryStorage.getCategories;
import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;
import static by.teachmeskills.eshop.utils.Utils.LOGIN;
import static by.teachmeskills.eshop.utils.Utils.PASSWORD;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Optional.ofNullable(request.getSession().getAttribute("username")).isPresent()) {
            User user = (User) request.getSession().getAttribute("username");
            checkReceivedUser(user, request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGIN = request.getParameter("username");
        PASSWORD = request.getParameter("password");
        try {
            validateParamNotNull(LOGIN);
            validateParamNotNull(PASSWORD);
            User user = new User(LOGIN, PASSWORD);
            checkReceivedUser(user, request, response);
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("username", UserStorage.getEqualUser(user));
        } catch (RequestParamNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkReceivedUser(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserStorage.isUserSuit(user)) {
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
