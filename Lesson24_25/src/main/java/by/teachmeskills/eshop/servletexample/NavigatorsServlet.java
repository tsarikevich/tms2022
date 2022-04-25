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

@WebServlet("/navigators")
public class NavigatorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("username");
        if (isUserLogIn(user)) {
            List<Product> navigators = new ArrayList<>();
            Product navigatorGeofox = new Product("navigatorGeofox.jpg",
                    "GPS навигатор GEOFOX MID502GPS",
                    "экран 5\" TFT (800 x 480), ОЗУ 128 Мб, флэш-память 8 Гб, Windows CE 6.0",
                    222);
            Product navigatorNavitel = new Product("navigatorNavitel.jpg",
                    "GPS навигатор NAVITEL E707 Magnetic",
                    "экран 7\" TFT (800 x 480), процессор MStar MSB2531 800 МГц, флэш-память 8 Гб, Linux",
                    342);
            navigators.add(navigatorGeofox);
            navigators.add(navigatorNavitel);
            request.setAttribute("products", navigators);
            response.setContentType("text/html");
            String categoryName = "GPS Navigators";
            request.setAttribute("categoryName", categoryName);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
