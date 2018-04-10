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

@WebServlet("/user")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UsersRepository repo = new DummyUsersRepository();
		
		response.getWriter().println("<h2>Your profile:</h2>");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			response.getWriter().println("User attribute not found!");
			return;
		}
		//pobranie aktualnych danych z bazy graczy, a nie z sesji
		//1. nick z sesji
		String nick = ((User)session.getAttribute("user")).getUsername();
		//2. user z bazy na podstawie nicku
		User user = repo.getUserByName(nick);
		
		response.getWriter().print("<table border='1'>");
		response.getWriter().print("<tr><td>Username</td><td>" + user.getUsername() + "</td></tr>");
		response.getWriter().print("<tr><td>Email</td><td>" + user.getEmail() + "</td></tr>");
		response.getWriter().print("<tr><td>Password</td><td>" + user.getPassword() + "</td></tr>");
		response.getWriter().print("<tr><td>Premium</td><td>" + user.isPremium() + "</td></tr>");
		response.getWriter().print("</table>");
		response.getWriter().print("<br/><br/><a href='home.jsp'>Home</a>");
	}


}
