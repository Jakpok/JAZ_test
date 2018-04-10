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

@WebServlet("/premiumManage")
public class PremiumManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PremiumManageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersRepository repo = new DummyUsersRepository();
		
		String username = request.getParameter("username");
		String action = request.getParameter("action");
		
		User user = repo.getUserByName(username);
		if(user == null){
			response.getWriter().print("User not found");
			return;
		}
		response.setContentType("text/html");
		if(action.equalsIgnoreCase("set")){
			user.setPremium(true);
			response.getWriter().print("This user is now premium");
		}
		else if(action.equalsIgnoreCase("remove")){
			user.setPremium(false);
			response.getWriter().print("Premium status removed");
		}
		else{
			response.getWriter().print("Invalid action");
		}
		user.updateChanges();
		response.getWriter().print("<br/><br/><a href='home.jsp'>Home</a>");
		
	}


}
