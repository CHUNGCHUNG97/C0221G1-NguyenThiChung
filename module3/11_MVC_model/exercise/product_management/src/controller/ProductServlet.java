package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "view";
        }
        switch (action) {
            case "view": {
                showProductList(request, response);
                break;
            }
            case "add": {
                addProduct(request, response);
                break;
            }
            case "edit": {
                updateProduct(request, response);
                break;
            }
            case "remove": {

            }
            default: {
                break;
            }
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String manufacture = request.getParameter("manufacture");
        Product product = new Product(id, name, price, manufacture);
        productService.update(product.getId(), product);
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "view";
        }
        switch (action) {
            case "view": {
                showProductList(request, response);
                break;
            }
            case "add": {
                showFormAdd(request, response);
                break;
            }
            case "edit": {
                showFormEdit(request, response);
                break;
            }
            case "remove": {
                remove(request, response);
                break;
            }
            case "search": {
                showFormSearch(request, response);
            }
            default: {
                break;
            }
        }
    }

    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("products", productService.search(name));
        request.getRequestDispatcher("view/list.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            productService.remove(id);
            response.sendRedirect("/");
        }

    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("product", productService.findById(Integer.parseInt(id)));
        request.getRequestDispatcher("view/edit.jsp").forward(request, response);
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("view/add.jsp").forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String manufacture = request.getParameter("manufacture");
        Product product = new Product(id, name, price, manufacture);
        productService.add(product);
        response.sendRedirect("/");

    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("view/list.jsp").forward(request, response);
    }
}
