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

@WebServlet(value = "/login")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = new User();
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        if (!user.getEmail().equals(email) || !user.getPassword().equals(password)) {
            doGet(request, response);
        } else {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
            response.sendRedirect("/home");
        }
    }
}
