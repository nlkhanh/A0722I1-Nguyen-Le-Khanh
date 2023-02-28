package furama_resort.controller;

import com.GetObject;
import com.UserManager;
import furama_resort.model.AttachService;
import furama_resort.model.GeneralType;
import furama_resort.model.User;
import furama_resort.model.contract.Contract;
import furama_resort.model.contract.ContractDetail;
import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;
import furama_resort.model.service_model.Service;
import furama_resort.service.FuramaServiceImpl;
import furama_resort.service.GeneralTypeServiceImpl;
import furama_resort.service.IFuramaService;
import furama_resort.service.IGeneralTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractServlet", value = "/furama-resort/contract")
public class ContractServlet extends HttpServlet {

    private static IFuramaService<Contract> furamaService;
    private static IGeneralTypeService generalTypeService;
    private static String typeName;
    private static int recordLimit;
    private static int pageLimit;

    @Override
    public void init() throws ServletException {
        furamaService = new FuramaServiceImpl<>();
        generalTypeService = new GeneralTypeServiceImpl();
        typeName = "contract";
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
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        IFuramaService<Customer> furamaServiceCustomer = new FuramaServiceImpl<>();
        IFuramaService<Employee> furamaServiceEmployee = new FuramaServiceImpl<>();
        IFuramaService<Service> furamaServiceService = new FuramaServiceImpl<>();
        IFuramaService<AttachService> furamaServiceServiceAttach = new FuramaServiceImpl<>();
        Customer customer = furamaServiceCustomer.getById("customer", customerId);
        List<Employee> employees = furamaServiceEmployee.getAll("employee");
        List<Service> services = furamaServiceService.getAll("service");
        List<AttachService> attachServices = furamaServiceServiceAttach.getAll("attach_service");

        request.setAttribute("customer", customer);
        request.setAttribute("employees", employees);
        request.setAttribute("services", services);
        request.setAttribute("attachServices", attachServices);
        request.getRequestDispatcher("/furama-resort/contract/create.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            furamaService.add(typeName, (Contract) GetObject.getObjectServlet(typeName, request, response));
            Contract contract = furamaService.getLast(typeName);
            List<String> useAttachService = Arrays.asList(request.getParameterValues("useAttachService"));
            if (useAttachService.size() > 0) {
                for (int i = 0; i < useAttachService.size(); i++) {
                    int attachServiceId = Integer.parseInt(useAttachService.get(i));
                    int quantity = Integer.parseInt(request.getParameter("quantity-" + attachServiceId));
                    IFuramaService<ContractDetail> furamaServiceContractDetail = new FuramaServiceImpl<>();
                    furamaServiceContractDetail.add("contract_detail", new ContractDetail(contract.getId(), attachServiceId, quantity));
                }
            }
        } catch (SQLException e) {
            request.setAttribute("message", "Create failed!");
        }
    }
}
