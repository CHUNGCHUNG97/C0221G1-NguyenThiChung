package controller;

import model.bean.User;
import model.service.IUserService;
import model.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/user"})
public class UserServlet extends HttpServlet {
    IUserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                insertUser(request, response);
                break;
            }
            case "edit": {
                updateUser(request, response);
                break;
            }
            default:
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showFormCreate(request, response);
                break;
            }
            case "edit": {
                showFormEdit(request, response);
                break;
            }
            case "delete": {
                deleteUser(request, response);
                break;
            }
            case "permission": {
                addUserPermision(request, response);
                break;
            }
            default:
                showUserList(request, response);
                break;
        }
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(null, "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1};

        userService.addUserTransaction(user, permision);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("name");
        String country = request.getParameter("name");
        User user = new User(name, email, country);
        userService.insertUserStore(user);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(id);
        if (user == null) {
            request.getRequestDispatcher("view/error_404.jsp");
        } else {
            request.setAttribute("user", user);
            try {
                request.getRequestDispatcher("view/edit.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        boolean check = userService.updateUser(id, user);
        user = userService.selectUserById(id);
        if (check) {
            request.setAttribute("message", "edit success");
        } else {
            request.setAttribute("message", "edit not success");
        }
        request.setAttribute("users", user);
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.callAllUsers();
        try {
            request.setAttribute("users", userList);
            request.getRequestDispatcher("view/user.jsp").forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
