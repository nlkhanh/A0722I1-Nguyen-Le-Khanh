package controller;

import model.Department;
import service.IService;
import service.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/department")
public class DepartmentServlet extends HttpServlet {

    private IService service = new ServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                create(request, response);
                break;
            case "delete":

                break;
            default:

        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = service.getAll();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create.jsp");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String areaStr = request.getParameter("area");
        double area = Double.parseDouble(areaStr);
        String status = request.getParameter("status");
        String floorStr = request.getParameter("floor");
        int floor = Integer.parseInt(floorStr);
        String type = request.getParameter("type");
        String detail = request.getParameter("detail");
        String costStr = request.getParameter("cost");
        double cost = Double.parseDouble(costStr);
        String startDateStr = request.getParameter("startDate");
        if (startDateStr == null) {
            startDateStr = "0000-00-00";
        }
        Date startDate = null;
        String endDateStr = request.getParameter("endDate");
        if (endDateStr == null) {
            endDateStr = "0000-00-00";
        }
        Date endDate = null;
        try {
            startDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr).getTime());
            endDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            service.insert(new Department(code, area, status, floor, type, detail, cost, startDate, endDate));
            response.sendRedirect("department");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            service.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("department");
    }
}
