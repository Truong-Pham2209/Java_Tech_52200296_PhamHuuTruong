package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!validateUser(username, password)) {
            req.getSession().setAttribute("flashMessage", "Username or Password is invalid");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        resp.addCookie(new Cookie("username", username));
        if (req.getParameter("remember") != null) {
            String token = generateToken();
            if (req.getSession().getAttribute("loginTokens") == null)
                req.getSession().setAttribute("loginTokens", new ArrayList<String>());
            ((ArrayList<String>) req.getSession().getAttribute("loginTokens")).add(token);
            Cookie cookie = new Cookie("loginToken", token);
            cookie.setMaxAge(30 * 24 * 60 * 60);
            resp.addCookie(cookie);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private boolean validateUser(String username, String password) {
        return UserDAO.getInstance().checkLogin(username, password);
    }

    private String generateToken() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer token = new StringBuffer();
        Random ran = new Random();
        for (int i = 0; i < 9; i++) {
            token.append(chars.charAt(ran.nextInt(chars.length())));
        }

        return token.toString();
    }

}
