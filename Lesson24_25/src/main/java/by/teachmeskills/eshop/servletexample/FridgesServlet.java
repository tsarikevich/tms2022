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

@WebServlet("/fridges")
public class FridgesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("username");
        if (isUserLogIn(user)) {
            String categoryName = "Fridges";
            request.setAttribute("categoryName", categoryName);
            List<Product> fridges = new ArrayList<>();
            Product fridgeBosch = new Product("fridgeBosch.jpg",
                    "Холодильник Bosch Serie 6 VitaFresh Plus KGN39AI32R",
                    "отдельностоящий, полный No Frost, " +
                            "электронное управление, класс A++, полезный объём: 388 л (280 + 108 л), " +
                            "инверторный компрессор, зона свежести, перенавешиваемые двери, складная полка, " +
                            "полка для вина, лоток для яиц, отделка: защита от отпечатков, 60x66x203 см, " +
                            "нержавеющая сталь", 2950);
            Product fridgeSamsung = new Product("fridgeSamsung.jpg",
                    "Холодильник Samsung RB37A52N0B1/WT",
                    "отдельностоящий, полный No Frost, электронное управление, класс A+, " +
                            "полезный объём: 367 л (269 + 98 л), инверторный компрессор, перенавешиваемые двери, " +
                            "лоток для яиц, 59.5x64.7x201 см, черный", 2248);
            fridges.add(fridgeBosch);
            fridges.add(fridgeSamsung);
            request.setAttribute("products", fridges);
            response.setContentType("text/html");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
