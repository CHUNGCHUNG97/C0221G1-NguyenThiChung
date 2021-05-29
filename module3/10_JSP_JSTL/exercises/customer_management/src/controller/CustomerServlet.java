package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {

    CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "view";
        }
        switch (action) {
            case "add": {
                break;
            }
            case "edit": {
                update(request, response);
                break;
            }
            case "delete": {
                break;
            }
            case "view": {
                showCustomerList(request, response);
            }
            default:
                break;
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        customerService.update(id, customer);
        customer = customerService.findById(id);
        request.setAttribute("mes", "update success");
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("view/edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "view";
        }
        switch (action) {
            case "add": {
                break;
            }
            case "edit": {
                showEditForm(request, response);
                break;
            }
            case "delete": {

                break;
            }
            case "view": {
                showCustomerList(request, response);
            }
            default:
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        request.setAttribute("customer", customerService.findById(Integer.parseInt(id)));
        request.getRequestDispatcher("view/edit.jsp").forward(request, response);
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }
}
