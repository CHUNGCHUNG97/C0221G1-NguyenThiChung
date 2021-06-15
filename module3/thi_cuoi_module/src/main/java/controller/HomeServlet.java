package controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"", "/home"})
public class HomeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            request.getRequestDispatcher("../main/webapp/view/home.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("../main/webapp/view/404.jsp").forward(request, response);

        }
    }
}
