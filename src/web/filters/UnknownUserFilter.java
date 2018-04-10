package web.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.webapp.SessionManager;

@WebFilter("/*")
public class UnknownUserFilter implements Filter {

	//niezalogowany uzytkownik moze dostep tylko do stron home, login i register
	private final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("", "/loginForm.jsp", "/registerForm.jsp","/home.jsp","/login","/register")));

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", ""); 

        boolean loggedIn = SessionManager.getInstance().isLoggedUser(req);
        boolean allowedPath = ALLOWED_PATHS.contains(path);

        if (loggedIn || allowedPath) {
            chain.doFilter(req, res);
        }
        else {
            response.sendRedirect("loginForm.jsp");
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
