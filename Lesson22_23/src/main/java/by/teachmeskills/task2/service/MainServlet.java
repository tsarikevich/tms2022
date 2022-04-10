package by.teachmeskills.task2.service;

import by.teachmeskills.task2.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        response.setCharacterEncoding("cp866");
        if (!user.getEmail().equals(email) || !user.getPassword().equals(password)) {
            response.getWriter().write("Вы ввели неверные значения пароля или логина");
        } else {
            response.getWriter().write("Пользователь вошел в аккаунт со следующими данными:" +
                    "\nлогин: " + email + "\nпароль: " + password);
        }
    }
}
