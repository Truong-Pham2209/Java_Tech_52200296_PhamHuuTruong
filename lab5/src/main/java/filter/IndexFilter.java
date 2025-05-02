package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/index.jsp")
public class IndexFilter implements Filter {
    @SuppressWarnings("unchecked")
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            req.getSession().setAttribute("flashMessage", "Please loggin");
            dispatcher.forward(req, resp);
            return;
        }

        if (req.getSession().getAttribute("loginTokens") != null) {
            List<String> loginTokens = (ArrayList<String>) req.getSession().getAttribute("loginTokens");
            if (loginTokens.contains(Arrays.stream(req.getCookies()).filter(x -> x.getName().equals("loginToken"))
                    .map(Cookie::getValue).findFirst().orElse(""))) {
                chain.doFilter(req, resp);
                return;
            }
        }

        req.getSession().setAttribute("flashMessage", "Please loggin");
        dispatcher.forward(req, resp);
        return;

    }
}