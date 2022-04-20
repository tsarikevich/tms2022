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

@WebServlet("/mobiles")
public class MobilesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isUserLogIn((User) request.getSession().getAttribute("username"))) {
            List<Product> mobiles = new ArrayList<>();
            Product mobileApple = new Product("mobileApple.jpg",
                    "Смартфон Apple iPhone 13 128GB (темная ночь)",
                    "Apple iOS, экран 6.1\" OLED (1170x2532), Apple A15 Bionic, ОЗУ 4 ГБ, флэш-память 128 ГБ, " +
                            "камера 12 Мп, аккумулятор 3227 мАч, 1 SIM", 2600);
            Product mobileSamsung = new Product("mobileSamsung.jpg",
                    "Смартфон Samsung Galaxy A52 SM-A525F/DS 8GB/256GB (синий)",
                    "Android, экран 6.5\" AMOLED (1080x2400), Qualcomm Snapdragon 720G, ОЗУ 8 ГБ, флэш-память 256 ГБ," +
                            " карты памяти, камера 64 Мп, аккумулятор 4500 мАч, 2 SIM", 1200);
            mobiles.add(mobileApple);
            mobiles.add(mobileSamsung);
            request.setAttribute("products", mobiles);
            response.setContentType("text/html");
            String categoryName = "Mobile phones";
            request.setAttribute("categoryName", categoryName);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
