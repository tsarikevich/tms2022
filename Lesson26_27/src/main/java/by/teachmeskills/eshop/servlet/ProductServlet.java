package by.teachmeskills.eshop.servlet;

import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static by.teachmeskills.eshop.utils.Utils.isUserLogIn;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("username");
        if (isUserLogIn(user)) {
            int product_id = Integer.parseInt(request.getParameter("idProduct"));
            Product product = getProductById(product_id);
            request.setAttribute("oneProduct", product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private Product getProductById(int id) {
        Product product = null;
        switch (id) {
            case 1 -> {
                product = new Product(1, "mobileApple.jpg",
                        "Смартфон Apple iPhone 13 128GB (темная ночь)",
                        "Apple iOS, экран 6.1'' OLED (1170x2532), Apple A15 Bionic, ОЗУ 4 ГБ, флэш-память 128 ГБ, " +
                                "камера 12 Мп, аккумулятор 3227 мАч, 1 SIM",
                        new BigDecimal("2600"), 1);
            }
            case 2 -> {
                product = new Product(2, "mobileSamsung.jpg",
                        "Смартфон Samsung Galaxy A52 SM-A525F/DS 8GB/256GB (синий)",
                        "Android, экран 6.5'' AMOLED (1080x2400), Qualcomm Snapdragon 720G, ОЗУ 8 ГБ, флэш-память 256 ГБ," +
                                " карты памяти, камера 64 Мп, аккумулятор 4500 мАч, 2 SIM",
                        new BigDecimal("1200"), 1);
            }
            case 3 -> {
                product = new Product(3, "laptopLenovo.jpg",
                        "Игровой ноутбук Lenovo Legion 5 15ACH6H 82JU00A1PB",
                        "15.6'' 1920 x 1080 IPS, 120 Гц, несенсорный, AMD Ryzen 7 5800H 3200 МГц, 16 ГБ DDR4," +
                                " SSD 512 ГБ, видеокарта NVIDIA GeForce RTX 3060 6 ГБ, Windows 10, цвет крышки темно-синий",
                        new BigDecimal("5500"), 2);
            }
            case 4 -> {
                product = new Product(4, "laptopAcer.jpg",
                        "Игровой ноутбук Acer Nitro 5 AN515-45-R1A6 NH.QBREP.00B",
                        "15.6'' 1920 x 1080 IPS, 144 Гц, несенсорный, AMD Ryzen 5 5600H 3300 МГц, 16 ГБ DDR4," +
                                " SSD 1024 ГБ, видеокарта NVIDIA GeForce RTX 3070 8 ГБ, Linux, цвет крышки черный",
                        new BigDecimal("5000"), 2);
            }
            case 5 -> {
                product = new Product(5, "navigatorGeofox.jpg",
                        "GPS навигатор GEOFOX MID502GPS",
                        "экран 5'' TFT (800 x 480), ОЗУ 128 Мб, флэш-память 8 Гб, Windows CE 6.0",
                        new BigDecimal("222"), 3);
            }
            case 6 -> {
                product = new Product(6, "navigatorNavitel.jpg",
                        "GPS навигатор NAVITEL E707 Magnetic",
                        "экран 7'' TFT (800 x 480), процессор MStar MSB2531 800 МГц, флэш-память 8 Гб, Linux",
                        new BigDecimal("342"), 3);
            }
            case 7 -> {
                product = new Product(7, "fridgeBosch.jpg",
                        "Холодильник Bosch Serie 6 VitaFresh Plus KGN39AI32R",
                        "отдельностоящий, полный No Frost, " +
                                "электронное управление, класс A++, полезный объём: 388 л (280 + 108 л), " +
                                "инверторный компрессор, зона свежести, перенавешиваемые двери, складная полка, " +
                                "полка для вина, лоток для яиц, отделка: защита от отпечатков, 60x66x203 см, " +
                                "нержавеющая сталь", new BigDecimal("2950"), 4);
            }
            case 8 -> {
                product = new Product(8, "fridgeSamsung.jpg",
                        "Холодильник Samsung RB37A52N0B1/WT",
                        "отдельностоящий, полный No Frost, электронное управление, класс A+, " +
                                "полезный объём: 367 л (269 + 98 л), инверторный компрессор, перенавешиваемые двери, " +
                                "лоток для яиц, 59.5x64.7x201 см, черный",
                        new BigDecimal("2248"), 4);
            }
            case 9 -> {
                product = new Product(9, "carVolvo.jpg",
                        "Volvo XC40", "1.6 T3 MT Turbo Momentum",
                        new BigDecimal("87832"), 5);
            }
            case 10 -> {
                product = new Product(10, "carTesla.jpg",
                        "Tesla Model X",
                        "электрический двигатель, P100D Long Range",
                        new BigDecimal("272107"), 5);
            }
            case 11 -> {
                product = new Product(11, "cameraCanon.jpg",
                        "Зеркальный фотоаппарат Canon EOS 4000D Kit 18-55mm III",
                        "зеркальная камера, байонет Canon EF-S, матрица APS-C (1.6 crop) 18 Мп," +
                                " с объективом F3.5-5.6 18-55 мм, Wi-Fi",
                        new BigDecimal("1449"), 6);
            }
            case 12 -> {
                product = new Product(12, "cameraNikon.jpg",
                        "Зеркальный фотоаппарат Nikon D5600 Kit 18-55mm AF-P DX VR",
                        "Зеркальный фотоаппарат Nikon D5600 Kit 18-55mm AF-P DX VR",
                        new BigDecimal("2550"), 6);
            }
            default -> System.out.println("Некорректный id продукта");

        }
        return product;
    }
}
