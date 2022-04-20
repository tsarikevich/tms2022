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

@WebServlet("/cameras")
public class CamerasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isUserLogIn((User) request.getSession().getAttribute("username"))) {
            List<Product> cameras = new ArrayList<>();
            Product cameraCanon = new Product("cameraCanon.jpg",
                    "Зеркальный фотоаппарат Canon EOS 4000D Kit 18-55mm III",
                    "зеркальная камера, байонет Canon EF-S, матрица APS-C (1.6 crop) 18 Мп," +
                            " с объективом F3.5-5.6 18-55 мм, Wi-Fi", 1449);
            Product cameraNikon = new Product("cameraNikon.jpg",
                    "Зеркальный фотоаппарат Nikon D5600 Kit 18-55mm AF-P DX VR",
                    "Зеркальный фотоаппарат Nikon D5600 Kit 18-55mm AF-P DX VR", 2550);
            cameras.add(cameraCanon);
            cameras.add(cameraNikon);
            request.setAttribute("products", cameras);
            response.setContentType("text/html");
            String categoryName = "Cameras";
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
