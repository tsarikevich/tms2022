package by.teachmeskills.task1.service;

import by.teachmeskills.task1.model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/calculator"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String varSum = "Сумма чисел - " + Calculator.sum(5.3, 6.2);
        request.setAttribute("sum", varSum);
        String varMultiply = "Произведение чисел - " + Calculator.multiply(1.2, 5);
        request.setAttribute("multiply", varMultiply);
        String varDivide = "Частное чисел - " + Calculator.divide(8.5, 0.5);
        request.setAttribute("divide", varDivide);
        String varSubtraction = "Разность чисел - " + Calculator.subtraction(10.3, 7.3);
        request.setAttribute("subtraction", varSubtraction);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }
}
