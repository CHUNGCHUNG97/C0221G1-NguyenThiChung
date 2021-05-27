package customer_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    List<Customer> customerList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String address=request.getParameter("address");
        String img =request.getParameter("img");
        Customer customer = new Customer(name, birthday, address, img);
        customerList.add(customer);
        request.setAttribute("list", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (customerList.isEmpty()) {
            customerList.add(new Customer("Thạch", "1/6/1899", "Đà Nẵng", "https://aphoto.vn/wp-content/uploads/2018/02/anh-dep-chup-dien-thoai.jpg"));
        }
        request.setAttribute("list", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
