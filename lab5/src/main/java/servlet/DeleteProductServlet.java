package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        PrintWriter writer = resp.getWriter();

        if (id == null) {
            writer.write("Delete failure!");
            return;
        }
        ProductDAO.getInstance().delete(Integer.parseInt(id));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
