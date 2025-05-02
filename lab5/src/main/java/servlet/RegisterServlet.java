package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String message = "Register success";
        PrintWriter writer = resp.getWriter();
        if (name == null || email == null || password == null) {
            writer.write("Register failure!");
            return;
        }
        if (UserDAO.getInstance().getUserByUsername(name) != null) {
            writer.write("Username have already exist!");
            return;
        }
        UserDAO.getInstance().save(new User(name, password));
        writer.write(message);
    }

}
