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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		
		UsersRepository repo = new DummyUsersRepository();
		
		User user = repo.getUserByName(login);
		if(user == null){
			response.getWriter().write("User not found");
			return;
		}
		if(user.getPassword().equals(password)){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("user");
		}
		else{
			response.getWriter().write("Bad password!");
		}
	}


}
