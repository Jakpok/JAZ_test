package main.webapp;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {

	private static SessionManager INSTANCE;
	
	private SessionManager(){}
	
	public static SessionManager getInstance(){
        if(INSTANCE==null)
            INSTANCE = new SessionManager();
        return INSTANCE;
    }
	
	public boolean isLoggedUser(ServletRequest req){
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		boolean loggedIn = (session != null && session.getAttribute("user") != null);
		return loggedIn;
	}
	
	public User getUserFromSession(ServletRequest req){
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("user") != null){
			return ((User)session.getAttribute("user"));
		}
		return null;	
	}
	
}
