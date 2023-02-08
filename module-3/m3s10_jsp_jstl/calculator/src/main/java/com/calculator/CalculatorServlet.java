package com.calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
        String operator = request.getParameter("operator");
        double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));

        request.setAttribute("firstOperand", firstOperand);
        request.setAttribute("operator", operator);
        request.setAttribute("secondOperand", secondOperand);
        Calculator calculator = new Calculator(firstOperand, operator, secondOperand);
        double result;
        try {
            result = calculator.calculate();
            request.setAttribute("result", result);
        } catch (ArithmeticException e) {
            request.setAttribute("result", e);
        }
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
