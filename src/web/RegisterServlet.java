package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.webapp.User;
import repositories.DummyUsersRepository;
import repositories.UsersRepository;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RegisterServlet() {
        super();
    }
	
	private User getUserFromRequest(HttpServletRequest request){
		User user = new User(request.getParameter("username"),request.getParameter("password"),request.getParameter("email"));
		return user;	
	}
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameter("password").equals(request.getParameter("password2"))){
			response.getWriter().write("Passwords do not match");
			return;
		}
			
		User user = getUserFromRequest(request);
		UsersRepository repo = new DummyUsersRepository();
		
		if(repo.getUserByName(user.getUsername()) != null){
			response.getWriter().write("This nick is already taken. Please change your username");
			return;
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user", user);
		
		repo.add(user);
		
		response.sendRedirect("home.jsp");
	}


}
