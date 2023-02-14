package controller;

import model.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService;

    private static final int RECORD_LIMIT = 5;
    private static final int PAGE_LIMIT = 7;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "search-by-country":
                    searchByCountry(request, response);
                    break;
                case "sort-by-name":
                    sortByName(request, response);
                    break;
                case "permission":
                    addUserPermission(request, response);
                    break;
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":
                    testUseTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String search = request.getParameter("search");
        if (search != null) {
            if (search.equals("")) {
                request.setAttribute("searchCountry", search);
                search = "dfhdkdjashdjhd";
            } else {
                request.setAttribute("searchCountry", search);
            }
        }

        String sort = request.getParameter("sort");

        String currentPageStr = request.getParameter("page");
        int currentPage;
        if (currentPageStr == null) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(currentPageStr);
        }

        int offset = getOffset(RECORD_LIMIT, currentPage);
        int numberOfPages = getNumberOfPages(search);
        List<User> users = getUsersForList(offset, search, sort);

        List<Integer> pageList = getPageList(currentPage, numberOfPages);

        if (sort != null) {
            request.setAttribute("sort", sort);
        }
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("pageList", pageList);
        request.setAttribute("users", users);
        request.setAttribute("current_page", currentPage);
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/user/create.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userService.selectUser(id);
        User existingUser = userService.getUserById(id);
        request.setAttribute("user", existingUser);
        request.getRequestDispatcher("/user/edit.jsp").forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        userService.deleteUser(id);
        userService.deleteUserStore(id);
        listUser(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
//        userService.insertUser(new User(name, email, country));
        userService.insertUserStore(new User(name, email, country));
        request.setAttribute("message", "New user was created");
        request.getRequestDispatcher("/user/create.jsp").forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
//        userService.updateUser(user);
        userService.updateUserStore(user);
        request.setAttribute("message", "User was updated");
        request.setAttribute("user", user);
        request.getRequestDispatcher("user/edit.jsp").forward(request, response);
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String search = request.getParameter("search");
        if (search.equals("")) {
            request.setAttribute("searchCountry", search);
            search = "dfhdkdjashdjhd";
        } else {
            request.setAttribute("searchCountry", search);
        }

        int currentPage = 1;
        int offset = getOffset(PAGE_LIMIT, currentPage);
        int numberOfPages = getNumberOfPages(search);
        List<User> users = getUsersForList(offset, search, null);
        List<Integer> pageList = getPageList(currentPage, numberOfPages);

        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("pageList", pageList);
        request.setAttribute("users", users);
        request.setAttribute("current_page", currentPage);

        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sort = "sort-by-name";

        String search = request.getParameter("search");
        if (search != null) {
            if (search.equals("")) {
                request.setAttribute("searchCountry", search);
                search = "dfhdkdjashdjhd";
            } else {
                request.setAttribute("searchCountry", search);
            }
        }

        int currentPage = 1;
        int offset = getOffset(RECORD_LIMIT, currentPage);
        int numberOfPages = getNumberOfPages(search);
        List<Integer> pageList = getPageList(currentPage, numberOfPages);
        List<User> users = getUsersForList(offset, search, sort);

        request.setAttribute("sort", sort);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("pageList", pageList);
        request.setAttribute("users", users);
        request.setAttribute("current_page", currentPage);

        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(10, "An", "quan.nguyen@codegym.vn", "Viet Nam");
        int[] permissions = {1, 2, 4};
        userService.addUserTransaction(user, permissions);
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateWithoutTransaction();
    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateUseTransaction();
    }

    private int getOffset(int recordLimit, int currentPage) {
        return (currentPage * recordLimit) - recordLimit;
    }

    private int getNumberOfPages(String search) {
        int numberOfList;
        if (search != null) {
            numberOfList = userService.getUsersByCountry(search).size();
        } else {
            numberOfList = userService.getAllUsers().size();
        }
        boolean checkNumberOfPages = (numberOfList % UserServlet.RECORD_LIMIT) == 0;
        if (checkNumberOfPages) {
            return (numberOfList / UserServlet.RECORD_LIMIT);
        }
        return (numberOfList / UserServlet.RECORD_LIMIT) + 1;
    }

    private List<Integer> getPageList(int currentPage, int numberOfPages) {
        List<Integer> pageList = new ArrayList<>(UserServlet.PAGE_LIMIT);

        int pageGroup = currentPage / UserServlet.PAGE_LIMIT;
        boolean checkPageLists = (currentPage % UserServlet.PAGE_LIMIT) != 0;
        if (checkPageLists) {
            pageGroup++;
        }

        int pageMax;
        int pageMin;
        if (numberOfPages <= UserServlet.PAGE_LIMIT) {
            pageMin = 1;
            pageMax = numberOfPages;
        } else {
            pageMax = pageGroup * UserServlet.PAGE_LIMIT;
            pageMin = pageMax - UserServlet.PAGE_LIMIT + 1;
            if (pageMax > numberOfPages) {
                pageMax = numberOfPages;
            }
        }
        for (int i = pageMin; i <= pageMax; i++) {
            pageList.add(i);
        }
        return pageList;
    }

    private List<User> getUsersForList(int offset, String search, String sort) {
        if (search != null && sort != null) {
            return userService.getUsersByCountrySortNamePagination(search, offset, UserServlet.RECORD_LIMIT);
        } else if (search != null) {
            return userService.getUsersByCountryPagination(search, offset, UserServlet.RECORD_LIMIT);
        } else if (sort != null) {
            return userService.getUsersSortNamePagination(offset, UserServlet.RECORD_LIMIT);
        } else {
            return userService.getAllUsersPagination(offset, UserServlet.RECORD_LIMIT);
        }
    }
}
