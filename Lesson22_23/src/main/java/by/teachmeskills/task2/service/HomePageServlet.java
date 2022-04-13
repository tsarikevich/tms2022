package by.teachmeskills.task2.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/home")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null && httpSession.getAttribute("password") != null && httpSession.getAttribute("email") != null) {
            String email = (String) httpSession.getAttribute("email");
            String password = (String) httpSession.getAttribute("password");
            request.setAttribute(password, password);
            request.setAttribute(password, email);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/login");
        }


    }
}
