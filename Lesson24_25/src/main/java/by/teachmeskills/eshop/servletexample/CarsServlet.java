package by.teachmeskills.eshop.servletexample;

import by.teachmeskills.eshop.model.Product;
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

import static by.teachmeskills.eshop.utils.Utils.isUserLogIn;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("username");
        if (isUserLogIn(user)) {
            List<Product> cars = new ArrayList<>();
            Product carVolvo = new Product("carVolvo.jpg",
                    "Volvo XC40", "1.6 T3 MT Turbo Momentum", 87832);
            Product carTesla = new Product("carTesla.jpg",
                    "Tesla Model X",
                    "электрический двигатель, P100D Long Range", 272107);
            cars.add(carVolvo);
            cars.add(carTesla);
            request.setAttribute("products", cars);
            response.setContentType("text/html");
            String categoryName = "Cars";
            request.setAttribute("categoryName", categoryName);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
