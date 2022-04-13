package by.teachmeskills.task2.service;

import by.teachmeskills.task2.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        response.setCharacterEncoding("cp866");
        PrintWriter printWriter = response.getWriter();
        if (!user.getEmail().equals(email) || !user.getPassword().equals(password)) {
            response.getWriter().write("Вы ввели неверные значения пароля или логина");
            response.sendRedirect("/login");
        } else {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("email", email);
            httpSession.setAttribute("password", password);
            printWriter.write("Пользователь вошел в аккаунт со следующими данными:" +
                    "\nлогин: " + email + "\nпароль: " + password);
            response.sendRedirect("/home");
        }
        printWriter.close();
    }
}
