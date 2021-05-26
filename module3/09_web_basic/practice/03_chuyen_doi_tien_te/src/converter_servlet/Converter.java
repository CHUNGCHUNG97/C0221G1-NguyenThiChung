package converter_servlet;

import javafx.print.Printer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "converter", value = "/convert")
public class Converter extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double rate = Double.parseDouble(request.getParameter("Rate"));
        double USD = Double.parseDouble(request.getParameter("USD"));
        double vnd = rate * USD;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>vnd: " + vnd + "vnd</h1>");
        printWriter.println("</html>");
    }
}
