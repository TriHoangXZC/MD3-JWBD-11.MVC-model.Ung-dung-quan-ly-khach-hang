package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomerForm(request, response);
                break;
            case "edit":
                showUpdateCustomerForm(request, response);
                break;
            case "delete":
                showDeleteCustomerForm(request, response);
                break;
            case "view":
                showCustomerDetail(request, response);
                break;
            default:
                showListCustomers(request, response);
                break;
        }
    }

    private void showCustomerDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showUpdateCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDeleteCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/delete.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("ListCustomer", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        customerService.updateById(id, customer);
        response.sendRedirect("/customers");
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteById(id);
        response.sendRedirect("/customers");
    }


    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        customerService.create(customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        requestDispatcher.forward(request, response);
//        response.sendRedirect("/customers");  //Dieu huong ve trang chu sau khi create
    }

}
