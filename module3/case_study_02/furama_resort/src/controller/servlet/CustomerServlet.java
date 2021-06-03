package controller.servlet;

import model.bean.Customer;
import model.bean.TypeCustomer;
import model.service.customer.CustomerServiceImpl;
import model.service.type_customer.TypeCustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    TypeCustomerServiceImpl typeCustomerService = new TypeCustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list": {
                showList(request, response);
                break;
            }
            case "create": {
                addCustomer(request, response);
                break;
            }
            case "edit": {
                update(request, response);
                break;
            }
            default:
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list": {
                showList(request, response);
                break;
            }
            case "create": {
                showCreate(request, response);
                break;
            }
            case "edit": {
                showFormEdit(request, response);
                break;
            }
            case "delete": {
                deleteCustomer(request, response);
                break;
            }
            default:
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("customer", customerService.findById(id));
        request.setAttribute("typeCustomers", typeCustomerService.getAll());
        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        int idTypeCustomer = Integer.parseInt(request.getParameter("typeCustomer"));
        String nameCustomer = request.getParameter("nameCustomer");
        String birthdayCustomer = request.getParameter("birthdayCustomer");
        String idCardCustomer = request.getParameter("idCardCustomer");
        int genderCustomer = Integer.parseInt(request.getParameter("genderCustomer"));
        String phoneCustomer = request.getParameter("phoneCustomer");
        String emailCustomer = request.getParameter("emailCustomer");
        String addressCustomer = request.getParameter("addressCustomer");
        Customer customer = new Customer(idCustomer,nameCustomer, birthdayCustomer, idCardCustomer, genderCustomer, phoneCustomer, emailCustomer, addressCustomer);
        customerService.update(customer,idTypeCustomer);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            customerService.remove(id);
            response.sendRedirect("/customer");
        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<TypeCustomer> typeCustomers = typeCustomerService.getAll();
            request.setAttribute("action", "create");
            request.setAttribute("typeCustomers", typeCustomers);
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idTypeCustomer = Integer.parseInt(request.getParameter("typeCustomer"));
        String nameCustomer = request.getParameter("nameCustomer");
        String birthdayCustomer = request.getParameter("birthdayCustomer");
        String idCardCustomer = request.getParameter("idCardCustomer");
        int genderCustomer = Integer.parseInt(request.getParameter("genderCustomer"));
        String phoneCustomer = request.getParameter("phoneCustomer");
        String emailCustomer = request.getParameter("emailCustomer");
        String addressCustomer = request.getParameter("addressCustomer");

        Customer customer = new Customer(nameCustomer, birthdayCustomer, idCardCustomer,
                genderCustomer, phoneCustomer, emailCustomer, addressCustomer);
        customerService.add(customer, idTypeCustomer);

        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("action", "list");
            request.setAttribute("list", customerService.findAll());
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }
}
