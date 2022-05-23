package by.teachmeskills.eshop.servlet;

import by.teachmeskills.eshop.model.Order;
import by.teachmeskills.eshop.model.OrderStorage;
import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static by.teachmeskills.eshop.utils.Utils.isUserLogIn;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (isUserLogIn(user)) {
            List<Order> orders = OrderStorage.getOrdersByUserId(user.getId());
            request.setAttribute("orders", orders);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        List<Product> cartProducts = (List<Product>) session.getAttribute("myProducts");
        BigDecimal orderPrice = (BigDecimal) session.getAttribute("totalCost");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Order order = new Order(orderPrice, date, user.getId(), cartProducts);
        OrderStorage.addNewOrder(order);
        cartProducts.clear();
        session.setAttribute("myProducts", cartProducts);
        doGet(request, response);
    }
}
