package product_discount_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Discount_servlet", value = "/display-discount")
public class Discount_servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String productDescription = request.getParameter("productDescription");
        float listPrice = Float.parseFloat(request.getParameter("listPrice"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));
        float discountAmount = (float) (listPrice * discountPercent * 0.01);
        float discountPrice = listPrice - discountAmount;
        request.setAttribute("ProductDescription",productDescription);
       request.setAttribute("ListPrice",listPrice);
       request.setAttribute("DiscountPercent",discountPercent);
       request.setAttribute("DiscountAmount",discountAmount);
       request.setAttribute("DiscountPrice",discountPrice);
        RequestDispatcher requestDispatcher  = request.getRequestDispatcher("WEB-INF/result.jsp");
        requestDispatcher.forward(request,response);
    }
}
