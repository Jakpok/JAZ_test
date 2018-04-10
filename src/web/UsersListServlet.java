package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.webapp.User;
import repositories.DummyUsersRepository;
import repositories.UsersRepository;

@WebServlet("/usersList")
public class UsersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsersListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UsersRepository repo = new DummyUsersRepository();
		response.getWriter().println("User list:");
		if(repo.getAllUsers().length == 0){
			response.getWriter().println("There are no users!");
			return;
		}
		
		response.getWriter().print("<table border='1'>");
		response.getWriter().print("<tr><th>Username</th><th>Premium</th></tr>");
		for(User user : repo.getAllUsers()){
			response.getWriter().print("<tr><td>" + user.getUsername() + "</td><td>" + user.isPremium() + "</td></tr>");
		}
		response.getWriter().print("</table>");
		response.getWriter().print("<br/><br/><a href='home.jsp'>Home</a>");
	}


}
