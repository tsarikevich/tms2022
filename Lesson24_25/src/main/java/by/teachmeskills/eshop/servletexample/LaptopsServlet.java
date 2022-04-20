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

@WebServlet("/laptops")
public class LaptopsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isUserLogIn((User) request.getSession().getAttribute("username"))) {
            List<Product> laptops = new ArrayList<>();
            Product laptopLenovo = new Product("laptopLenovo.jpg",
                    "Игровой ноутбук Lenovo Legion 5 15ACH6H 82JU00A1PB",
                    "15.6\" 1920 x 1080 IPS, 120 Гц, несенсорный, AMD Ryzen 7 5800H 3200 МГц, 16 ГБ DDR4," +
                            " SSD 512 ГБ, видеокарта NVIDIA GeForce RTX 3060 6 ГБ, Windows 10, цвет крышки темно-синий",
                    4850);
            Product laptopAcer = new Product("laptopAcer.jpg",
                    "Игровой ноутбук Acer Nitro 5 AN515-45-R1A6 NH.QBREP.00B",
                    "15.6\" 1920 x 1080 IPS, 144 Гц, несенсорный, AMD Ryzen 5 5600H 3300 МГц, 16 ГБ DDR4," +
                            " SSD 1024 ГБ, видеокарта NVIDIA GeForce RTX 3070 8 ГБ, Linux, цвет крышки черный",
                    5000);
            laptops.add(laptopLenovo);
            laptops.add(laptopAcer);
            request.setAttribute("products", laptops);
            response.setContentType("text/html");
            String categoryName = "Laptops";
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
