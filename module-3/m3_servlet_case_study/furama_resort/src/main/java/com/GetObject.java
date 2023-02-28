package com;

import furama_resort.model.User;
import furama_resort.model.contract.Contract;
import furama_resort.model.contract.ContractDetail;
import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;
import furama_resort.model.service_model.House;
import furama_resort.model.service_model.Room;
import furama_resort.model.service_model.Service;
import furama_resort.model.service_model.Villa;
import furama_resort.service.FuramaServiceImpl;
import furama_resort.service.IFuramaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GetObject {
    private static final IFuramaService FURAMA_SERVICE = new FuramaServiceImpl();

    private GetObject() {
    }

    public static Object getObjectServlet(String typeName, HttpServletRequest request, HttpServletResponse response) {
        switch (typeName) {
            case "customer":
                return getCustomerServlet(request, response);
            case "service":
                return getServiceServlet(request, response);
            case "user":
                return getUserServlet(request, response);
            case "contract":
                return getContractServlet(request, response);
            case "contract_detail":
                return getContractDetailServlet(request, response);
        }
        return null;
    }

    private static Customer getCustomerServlet(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String birthdayStr = request.getParameter("birthday");
        if (birthdayStr == null) {
            birthdayStr = "0000-00-00";
        }
        Date birthday;
        try {
            birthday = new Date((new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr)).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            return new Customer(id, name, birthday, gender, idCard, phone, email, address, customerTypeId);
        } else {
            return new Customer(name, birthday, gender, idCard, phone, email, address, customerTypeId);
        }
    }


    public static Employee getEmployee(HttpServletRequest request, HttpServletResponse response) throws ValidateException, ParseException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");

        String birthdayStr = request.getParameter("birthday");
        if (!FURAMA_SERVICE.validateDate(birthdayStr)) {
            throw new ValidateException();
        }
        Date birthday = new Date(new SimpleDateFormat("dd/MM/yyyy").parse(birthdayStr).getTime());

        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

        String idCard = request.getParameter("idCard");
        if (!FURAMA_SERVICE.validateIdCard(idCard)) {
            throw new ValidateException();
        }

        String phone = request.getParameter("phone");
        if (!FURAMA_SERVICE.validatePhoneNumber(phone)) {
            throw new ValidateException();
        }

        String email = request.getParameter("email");
        if (!FURAMA_SERVICE.validateEmail(email)) {
            throw new ValidateException();
        }

        String address = request.getParameter("address");

        String salaryStr = request.getParameter("salary");
        if (!FURAMA_SERVICE.validateDouble(salaryStr)) {
            throw new ValidateException();
        }
        double salary = Double.parseDouble(salaryStr);

        String username = request.getParameter("username");

        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));

        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            return new Employee(id, name, birthday, gender, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, username);
        } else {
            return new Employee(name, birthday, gender, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, username);
        }
    }

    private static Service getServiceServlet(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String desOtherConvenience = request.getParameter("otherConvenience");
        String poolAreaStr = request.getParameter("poolArea");
        double poolArea = 0;
        if (poolAreaStr != null) {
            poolArea = Double.parseDouble(poolAreaStr);
        }
        String numberOfFloorsStr = request.getParameter("numberOfFloors");
        int numberOfFloors = 0;
        if (numberOfFloorsStr != null) {
            numberOfFloors = Integer.parseInt(numberOfFloorsStr);
        }
        String freeService = request.getParameter("freeService");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            switch (serviceTypeId) {
                case 1:
                    return new Room(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, freeService);
                case 2:
                    return new House(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, desOtherConvenience, numberOfFloors);
                default:
                    return new Villa(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, desOtherConvenience, poolArea, numberOfFloors);
            }
        } else {
            switch (serviceTypeId) {
                case 1:
                    return new Room(name, area, cost, maxPeople, rentTypeId, serviceTypeId, freeService);
                case 2:
                    return new House(name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, desOtherConvenience, numberOfFloors);
                default:
                    return new Villa(name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, desOtherConvenience, poolArea, numberOfFloors);
            }
        }
    }

    public static User getUserServlet(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public static User getUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return new User(username, password);
    }

    private static Contract getContractServlet(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");

        String startDateStr = request.getParameter("startDate");
        if (startDateStr == null) {
            startDateStr = "0000-00-00";
        }
        Date startDate;
        try {
            startDate = new Date((new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr)).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String endDateStr = request.getParameter("endDate");
        if (endDateStr == null) {
            endDateStr = "0000-00-00";
        }
        Date endDate;
        try {
            endDate = new Date((new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr)).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            return new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
        }
        return new Contract(startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
    }

    private static ContractDetail getContractDetailServlet(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int attachServiceId = Integer.parseInt(request.getParameter("attachServiceId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            return new ContractDetail(id, contractId, attachServiceId, quantity);
        }
        return new ContractDetail(contractId, attachServiceId, quantity);
    }
}
