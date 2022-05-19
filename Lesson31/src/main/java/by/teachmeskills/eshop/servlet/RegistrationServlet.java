package by.teachmeskills.eshop.servlet;

import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.model.UserStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static int idUser;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isNewUserAdd", true);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("registration.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("newUsrLogin");
        String password = request.getParameter("newUsrPass");
        int month = Integer.parseInt(request.getParameter("brthMonth"));
        int year = Integer.parseInt(request.getParameter("brthYear"));
        int day = Integer.parseInt(request.getParameter("brthDay"));
        LocalDate localDate = LocalDate.of(year, month, day);
//        String date = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
//                        .withLocale(new Locale("ru"))
//                        .format(localDate);
        String name = request.getParameter("newUsrName");
        String surname = request.getParameter("newUsrSurname");
        String email = request.getParameter("newUsrEmail");
        User user = new User(login, password, name, surname, email, localDate);
        if (UserStorage.isUserInBase(user)) {
            request.setAttribute("isNewUserAdd", false);
            request.setAttribute("userLogin", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("registration.jsp");
            requestDispatcher.forward(request, response);
        } else {
            UserStorage.addNewUser(user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
