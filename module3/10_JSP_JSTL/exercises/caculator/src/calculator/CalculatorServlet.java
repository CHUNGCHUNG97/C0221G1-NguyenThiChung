package calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mes = "số bạn nhập không phù hợp";
        try {
            int first = Integer.parseInt(request.getParameter("first"));
            int second = Integer.parseInt(request.getParameter("second"));
            String calculate = request.getParameter("select");
            int result = 0;
            switch (calculate) {
                case "sum": {
                    result = (first + second);
                    break;
                }
                case "sub": {
                    result = first - second;
                    break;
                }
                case "mul": {
                    result = first * second;
                    break;
                }
                case "div": {
                    result = first / second;
                    break;
                }
                default:
            }
//            if(String.valueOf(result).equals("Infinity")){
//                throw new Exception("lỗi");
//            }
            request.setAttribute("result", result);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("result", mes);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
