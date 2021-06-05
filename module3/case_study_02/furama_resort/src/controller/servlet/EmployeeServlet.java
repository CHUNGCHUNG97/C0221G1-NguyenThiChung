package controller.servlet;

import model.bean.Employee;
import model.repository.employee.education_degree.EducationDegreeRepository;
import model.service.division.DivisionServiceImpl;
import model.service.education_degree.EducationDegreeServiceImpl;
import model.service.employee.EmployeeServiceImpl;
import model.service.position.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    PositionServiceImpl positionService = new PositionServiceImpl();
    EducationDegreeServiceImpl degreeService = new EducationDegreeServiceImpl();
    DivisionServiceImpl divisionService = new DivisionServiceImpl();

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
                addEmployee(request, response);
                break;
            }
            case "edit": {
//                update(request, response);
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
//                showFormEdit(request, response);
                break;
            }
            case "delete": {
//                deleteEmployee(request, response);
                break;
            }
        }
    }

//    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            employeeService.remove(id);
//            response.sendRedirect("/employee");
//        } catch (Exception e) {
//            request.getRequestDispatcher("view/404.jsp").forward(request, response);
//
//        }
//
//    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("action", "create");
            request.setAttribute("positions", positionService.getAll());
            request.setAttribute("educationDegrees", degreeService.getAll());
            request.setAttribute("divisions", divisionService.getAll());
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            int idPosition = Integer.parseInt(request.getParameter("idPosition"));
            int idEducation = Integer.parseInt(request.getParameter("idEducation"));
            int idDivision = Integer.parseInt(request.getParameter("idDivision"));
            String birthday = request.getParameter("birthday");
            String idCard = request.getParameter("idCard");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String userName = request.getParameter("userName");
            Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address);
            employeeService.add(employee, idPosition, idEducation, idDivision, userName);

            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        request.setAttribute("employee", employeeService.findById(id));
//        try {
//            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void update(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String fullName = request.getParameter("fullName");
//        Employee employee = new Employee(id, fullName);
//        employeeService.update(employee.getId(), employee);
//        try {
//            response.sendRedirect("/employee");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("action", "list");
            request.setAttribute("employees", employeeService.findAll());
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }
}
