package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PublicServlet", urlPatterns = {"/", "/furama"})
public class FuramaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String action = request.getParameter("action");
        request.setAttribute("type", type);
        request.setAttribute("action", action);
        System.out.println(type);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
