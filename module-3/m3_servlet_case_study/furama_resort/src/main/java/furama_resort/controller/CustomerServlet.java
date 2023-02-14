package furama_resort.controller;

import furama_resort.model.person.Customer;
import furama_resort.service.IService;
import furama_resort.service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/furama-resort/customer")
public class CustomerServlet extends HttpServlet {
    private static IService<Customer> customerService;
    private static int recordLimit;
    private static int pageLimit;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
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
            case "customer-list":
                showCustomerList(request, response);
                break;
            case "search":

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        int offset = getOffset(page);
        int numberOfPages = getNumberOfPages(search);
        List<Customer> customers = getCustomers(offset, search);
        List<Integer> pageList = getPageList(page, numberOfPages);

        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("pageList", pageList);
        request.setAttribute("customers", customers);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/furama-resort/customer/customer-list.jsp").forward(request, response);
    }

    private int getOffset(int page) {
        return (page - 1) * recordLimit;
    }

    private int getNumberOfPages(String search) {
        int numberOfList;
        if (search != null) {
            numberOfList = customerService.getSearch(search).size();
        } else {
            numberOfList = customerService.getAll().size();
        }
        boolean checkNumberOfPages = (numberOfList % recordLimit) == 0;
        if (checkNumberOfPages) {
            return (numberOfList / recordLimit);
        }
        return (numberOfList / recordLimit) + 1;
    }

    private List<Integer> getPageList(int page, int numberOfPages) {
        List<Integer> pageList = new ArrayList<>(pageLimit);

        int pageGroup = page / pageLimit;
        boolean checkPageLists = (page % pageLimit) != 0;
        if (checkPageLists) {
            pageGroup++;
        }

        int pageMax;
        int pageMin;
        if (numberOfPages <= pageLimit) {
            pageMin = 1;
            pageMax = numberOfPages;
        } else {
            pageMax = pageGroup * pageLimit;
            pageMin = pageMax - pageLimit + 1;
            if (pageMax > numberOfPages) {
                pageMax = numberOfPages;
            }
        }
        for (int i = pageMin; i <= pageMax; i++) {
            pageList.add(i);
        }
        return pageList;
    }

    private List<Customer> getCustomers(int offset, String search) {
        if (search != null) {
            return customerService.getSearchPagination(search, offset, recordLimit);
        } else {
            return customerService.getAllPagination(offset, recordLimit);
        }
    }
}
