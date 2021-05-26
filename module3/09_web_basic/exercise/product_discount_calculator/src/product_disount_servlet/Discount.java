package product_disount_servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "discount_servlet", value = "/display-discount")
public class Discount extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productDescription = request.getParameter("product description");
        float listPrice = Float.parseFloat(request.getParameter("list price"));
        float discountPercent = Float.parseFloat(request.getParameter("discount percent"));
        float discountAmount = (float) (listPrice * discountPercent * 0.01);
        float discountPrice = listPrice - discountAmount;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h3>Product Description: " + productDescription + "</h3>");
        printWriter.println("<h3>List Price: " + listPrice + "</h3>");
        printWriter.println("<h3>Discount Percent: " + discountPercent + "%</h3>");
        printWriter.println("<h3>Discount Amount: " + discountAmount + "%</h3>");
        printWriter.println("<h3>Discount Price: " + discountPrice + "%</h3>");
        printWriter.println("</html>");
    }
}
