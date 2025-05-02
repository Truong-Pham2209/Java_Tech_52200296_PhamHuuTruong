package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Logout")
public class LogoutServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String token = null;
        if (cookies != null) {
            token = Arrays.stream(cookies)
                    .filter(x -> x.getName().equals("loginToken"))
                    .map(Cookie::getValue).findFirst().orElse("");
        }
        if (token == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        Arrays.stream(cookies)
                .filter(x -> x.getName().equals("loginToken")).forEach(x -> {
                    x.setMaxAge(0);
                    resp.addCookie(x);
                });
        List<String> loginTokens = (ArrayList<String>) req.getSession().getAttribute("loginTokens");
        if (loginTokens != null && loginTokens.contains(token)) {
            loginTokens.remove(token);
        }
        resp.sendRedirect("login.jsp");
    }
}
