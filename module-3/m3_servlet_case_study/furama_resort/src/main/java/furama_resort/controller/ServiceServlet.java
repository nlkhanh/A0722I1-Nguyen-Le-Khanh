package furama_resort.controller;

import com.GetObject;
import com.Pagination;
import furama_resort.model.GeneralType;
import furama_resort.model.service_model.Service;
import furama_resort.model.service_model.House;
import furama_resort.model.service_model.Room;
import furama_resort.model.service_model.Villa;
import furama_resort.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/furama-resort/service")
public class ServiceServlet extends HttpServlet {
    private static IFuramaService<Service> furamaService;
    private static IGeneralTypeService generalTypeService;
    private static String typeName;
    private static int recordLimit;
    private static int pageLimit;

    @Override
    public void init() throws ServletException {
        furamaService = new FuramaServiceImpl<>();
        generalTypeService = new GeneralTypeServiceImpl();
        typeName = "service";
        recordLimit = 5;
        pageLimit = 7;
    }

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
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showList(request, response);
                break;
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
            case "edit":
                update(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        if (search != null) {
            if (search.equals("")) {
                request.setAttribute("search", search);
                search = "There are nothing to search at all";
            } else {
                request.setAttribute("search", search);
            }
        }

        String pageStr = request.getParameter("page");
        int page;
        if (pageStr == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pageStr);
        }

        int offset = Pagination.getOffset(recordLimit, page);
        int numberOfPages = Pagination.getNumberOfPages(furamaService, recordLimit, typeName, search);
        List<Service> services = (List<Service>) Pagination.getList(furamaService, recordLimit, typeName, offset, search);
        List<Integer> pageList = Pagination.getPageList(pageLimit, page, numberOfPages);
        List<GeneralType> serviceTypes = generalTypeService.getAll("service_type");
        List<GeneralType> rentTypes = generalTypeService.getAll("rent_type");

        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("serviceTypes", serviceTypes);
        request.setAttribute("rentTypes", rentTypes);
        request.setAttribute("pageList", pageList);
        request.setAttribute("services", services);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/furama-resort/service/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<GeneralType> serviceTypes = generalTypeService.getAll("service_type");
        List<GeneralType> rentTypes = generalTypeService.getAll("rent_type");
        request.setAttribute("serviceTypes", serviceTypes);
        request.setAttribute("rentTypes", rentTypes);
        request.getRequestDispatcher("/furama-resort/service/create.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = furamaService.getById(typeName, id);
        List<GeneralType> serviceTypes = generalTypeService.getAll("service_type");
        List<GeneralType> rentTypes = generalTypeService.getAll("rent_type");
        request.setAttribute("serviceTypes", serviceTypes);
        request.setAttribute("rentTypes", rentTypes);
        if (service != null) {
            request.setAttribute("service", service);
        }
        request.getRequestDispatcher("/furama-resort/service/edit.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            furamaService.add(typeName, (Service) GetObject.getObjectServlet(typeName, request, response));
            request.setAttribute("message", "Create succeed!");
            showList(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Create failed!");
            showList(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            furamaService.delete(typeName, id);
            request.setAttribute("message", "Delete succeed!");
            showList(request, response);
        } catch (SQLException e) {
            request.setAttribute("message", "Delete failed!");
            showList(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            furamaService.update(typeName, (Service) GetObject.getObjectServlet(typeName, request, response));
            request.setAttribute("message", "Update succeed!");
            showList(request, response);
        } catch (SQLException e) {
            request.setAttribute("message", "Update failed!");
            showList(request, response);
        }
    }
}
