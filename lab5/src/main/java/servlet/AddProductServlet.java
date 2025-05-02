package servlet;

import java.io.IOException;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(urlPatterns = "/AddProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String price = req.getParameter("price");
        if (productName == null || price == null) {
            return;
        }
        ProductDAO.getInstance().save(new Product(productName, Long.parseLong(price)));
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
