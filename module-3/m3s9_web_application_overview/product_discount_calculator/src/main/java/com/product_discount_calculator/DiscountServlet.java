package com.product_discount_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/discountCalculate")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float listPrice = Float.parseFloat(request.getParameter("listPrice"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));
        float discountAmount = (float) (listPrice * discountPercent * 0.01);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<h2>Discount Amount: " + discountAmount + "</h2>");
        out.println("<h2>Discount Price: " + listPrice * (1 - discountPercent) + "</h2>");
        out.println("</html>");
    }
}
