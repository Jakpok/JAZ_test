package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import main.webapp.SessionManager;

@WebFilter({"/loginForm.jsp","/registerForm.jsp"})
public class LoggedUserFilter implements Filter {

	//przekierowywanie zalogowanego usera na swoj profil
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        
        if(SessionManager.getInstance().isLoggedUser(req)){
        	response.sendRedirect("user");
        }
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}