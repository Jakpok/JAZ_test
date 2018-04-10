package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import main.webapp.SessionManager;

@WebFilter({"/premium.jsp"})
public class PremiumFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(SessionManager.getInstance().isLoggedUser(request)){
			if(SessionManager.getInstance().getUserFromSession(request).isPremium()){
				chain.doFilter(request, response);
				return;
			}
		}
		response.getWriter().print("You don't have access to this page");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
