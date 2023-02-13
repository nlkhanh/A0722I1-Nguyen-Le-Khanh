package com.product_manager.controller;

import com.product_manager.model.Product;
import com.product_manager.service.IProductService;
import com.product_manager.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private static final IProductService PRODUCT_SERVICE = new ProductServiceImpl();

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
                showDeleteForm(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                listProduct(request, response);
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
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "view":
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private static void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = PRODUCT_SERVICE.findAll();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("product/create.jsp");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String detail = request.getParameter("detail");
        String manufacturer = request.getParameter("manufacturer");
        int id = (int) (Math.random() * 10000);
        Product product = new Product(id, name, price, detail, manufacturer);
        PRODUCT_SERVICE.save(product);
        request.setAttribute("message", "New product was created");
        try {
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = PRODUCT_SERVICE.findById(id);
        try {
            if (product == null) {
                response.sendRedirect("error_404.jsp");
            } else {
                request.setAttribute("product", product);
                request.getRequestDispatcher("/product/edit.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String detail = request.getParameter("detail");
        String manufacturer = request.getParameter("manufacturer");
        Product product = PRODUCT_SERVICE.findById(id);
        try {
            if(product == null){
                request.getRequestDispatcher("error-404.jsp").forward(request, response);
            } else {
                product.setName(name);
                product.setPrice(price);
                product.setDetail(detail);
                product.setManufacturer(manufacturer);
                PRODUCT_SERVICE.update(id, product);
                request.setAttribute("product", product);
                request.setAttribute("message", "Product information was updated");
                request.getRequestDispatcher("product/edit.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = PRODUCT_SERVICE.findById(id);
        try {
            if (product == null) {
                request.getRequestDispatcher("error_404.jsp").forward(request, response);
            } else {
                request.setAttribute("product", product);
                request.getRequestDispatcher("/product/delete.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = PRODUCT_SERVICE.findById(id);
        try {
            if (product == null) {
                request.getRequestDispatcher("error_404.jsp").forward(request, response);
            } else {
                PRODUCT_SERVICE.remove(id);
                response.sendRedirect("/product");
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = PRODUCT_SERVICE.findById(id);
        try {
            if (product == null) {
                request.getRequestDispatcher("error_404.jsp").forward(request, response);
            } else {
                request.setAttribute("product", product);
                request.getRequestDispatcher("/product/view.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        List<Product> productList = PRODUCT_SERVICE.findByName(nameSearch);
        try {
            if (productList.isEmpty()) {
                request.getRequestDispatcher("error_404.jsp").forward(request, response);
            } else {
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("/product/list.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
