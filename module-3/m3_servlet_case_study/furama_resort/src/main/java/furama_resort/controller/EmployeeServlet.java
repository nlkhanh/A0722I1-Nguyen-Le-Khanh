package furama_resort.controller;

import com.GetObject;
import com.Pagination;
import com.UserManager;
import com.ValidateException;
import furama_resort.model.GeneralType;
import furama_resort.model.User;
import furama_resort.model.person.Employee;
import furama_resort.service.FuramaServiceImpl;
import furama_resort.service.GeneralTypeServiceImpl;
import furama_resort.service.IFuramaService;
import furama_resort.service.IGeneralTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/furama-resort/employee")
public class EmployeeServlet extends HttpServlet {
    private static IFuramaService<Employee> furamaService;
    private static IGeneralTypeService generalTypeService;
    private static String typeName;
    private static int recordLimit;
    private static int pageLimit;

    @Override
    public void init() throws ServletException {
        furamaService = new FuramaServiceImpl<>();
        generalTypeService = new GeneralTypeServiceImpl();
        typeName = "employee";
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
            case "delete":
                delete(request, response);
                break;
            case "edit":
                showEditForm(request, response);
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
            case "edit":
                update(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<GeneralType> positions = generalTypeService.getAll("position");
        List<GeneralType> divisions = generalTypeService.getAll("division");
        List<GeneralType> educationDegrees = generalTypeService.getAll("education_degree");
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
        List<Employee> employees = (List<Employee>) Pagination.getList(furamaService, recordLimit, typeName, offset, search);
        List<Integer> pageList = Pagination.getPageList(pageLimit, page, numberOfPages);

        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("pageList", pageList);
        request.setAttribute("employees", employees);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/furama-resort/employee/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<GeneralType> positions = generalTypeService.getAll("position");
        List<GeneralType> divisions = generalTypeService.getAll("division");
        List<GeneralType> educationDegrees = generalTypeService.getAll("education_degree");
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.getRequestDispatcher("/furama-resort/employee/create.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = furamaService.getById(typeName, id);
        String name = employee.getName();
        Date birthday = employee.getBirthday();
        boolean gender = employee.isGender();
        String idCard = employee.getIdCard();
        String phone = employee.getPhone();
        String email = employee.getEmail();
        String address = employee.getAddress();
        double salary = employee.getSalary();
        String username = employee.getUsername();
        int positionId = employee.getPositionId();
        int educationDegreeId = employee.getEducationDegreeId();
        int divisionId = employee.getDivisionId();

        List<GeneralType> positions = generalTypeService.getAll("position");
        List<GeneralType> divisions = generalTypeService.getAll("division");
        List<GeneralType> educationDegrees = generalTypeService.getAll("education_degree");

        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("birthday", birthday);
        request.setAttribute("gender", gender);
        request.setAttribute("idCard", idCard);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("address", address);
        request.setAttribute("salary", salary);
        request.setAttribute("username", username);
        request.setAttribute("positionId", positionId);
        request.setAttribute("educationDegreeId", educationDegreeId);
        request.setAttribute("divisionId", divisionId);
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.getRequestDispatcher("/furama-resort/employee/edit.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = GetObject.getUser(request, response);
            Employee employee = GetObject.getEmployee(request, response);
            boolean addUser = UserManager.addUser(user);
            if (addUser) {
                furamaService.add(typeName, employee);
                UserManager.addUserRole(employee);
                request.setAttribute("message", "Create succeed!");
                showList(request, response);
            } else {
                request.setAttribute("message", "Create failed! (User name is exist)");
                returnForm(request, response);
                request.getRequestDispatcher("/furama-resort/employee/create.jsp").forward(request, response);
            }
        } catch (ValidateException | ParseException e) {
            request.setAttribute("message", "Create failed! (Validation)");
            returnForm(request, response);
            request.getRequestDispatcher("/furama-resort/employee/create.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("message", "Create failed! (SQL exception)");
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
            Employee employee = GetObject.getEmployee(request, response);
            furamaService.update(typeName, employee);
            UserManager.updateUserRole(employee);
            request.setAttribute("message", "Update succeed!");
            showList(request, response);
        } catch (ValidateException | ParseException e) {
            request.setAttribute("message", "Update failed! (Validation)");
            returnForm(request, response);
            request.getRequestDispatcher("/furama-resort/employee/edit.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("message", "Update failed!");
            showList(request, response);
        }
    }

    private void returnForm(HttpServletRequest request, HttpServletResponse response) {
        List<GeneralType> positions = generalTypeService.getAll("position");
        List<GeneralType> divisions = generalTypeService.getAll("division");
        List<GeneralType> educationDegrees = generalTypeService.getAll("education_degree");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        String username = request.getParameter("username");
        String positionId = request.getParameter("positionId");
        String educationDegreeId = request.getParameter("educationDegreeId");
        String divisionId = request.getParameter("divisionId");

        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("birthday", birthday);
        request.setAttribute("gender", gender);
        request.setAttribute("idCard", idCard);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("address", address);
        request.setAttribute("salary", salary);
        request.setAttribute("username", username);
        request.setAttribute("positionId", positionId);
        request.setAttribute("educationDegreeId", educationDegreeId);
        request.setAttribute("divisionId", divisionId);
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educationDegrees", educationDegrees);
    }
}
