package by.teachmeskills.eshop.servlet;

import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.ProductStorage;
import by.teachmeskills.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.teachmeskills.eshop.utils.Utils.isUserLogIn;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (isUserLogIn(user)) {
            int product_id = Integer.parseInt(request.getParameter("productId"));
            Product product = ProductStorage.getProductById(product_id);
            request.setAttribute("oneProduct", product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
