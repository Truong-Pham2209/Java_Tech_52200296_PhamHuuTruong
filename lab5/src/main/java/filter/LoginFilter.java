package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/login.jsp")
public class LoginFilter implements Filter {
    @SuppressWarnings("unchecked")
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getSession().getAttribute("loginTokens") != null) {
            List<String> loginTokens = (ArrayList<String>) req.getSession().getAttribute("loginTokens");
            if (loginTokens.contains(Arrays.stream(req.getCookies()).filter(x -> x.getName().equals("loginToken"))
                    .map(Cookie::getValue).findFirst().orElse(""))) {
                // req.getRequestDispatcher("index.jsp").forward(request, response);
                resp.sendRedirect("index.jsp");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
