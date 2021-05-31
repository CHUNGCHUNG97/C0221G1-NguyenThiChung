package controller.servlet;

import model.service.employee.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            case "delete": {
                deleteEmployee(request, response);
                break;
            }
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            employeeService.remove(id);
//            request.setAttribute("type", "employee");
//            request.setAttribute("action", "list");
//            request.setAttribute("list", employeeService.findAll());
//            request.getRequestDispatcher("view/furama.jsp").forward(request, response);
            response.sendRedirect("/employee");
        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("type", "employee");
            request.setAttribute("action", "create");
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("type", "employee");
            request.setAttribute("action", "list");
            request.setAttribute("list", employeeService.findAll());
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }
}
