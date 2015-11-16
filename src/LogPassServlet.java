import java.io.IOException;
import database.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogPassServlet
 */
@WebServlet("/fuck")
public class LogPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableDB table1 = new TableDB();
		System.out.println(table1.logIn(request.getParameter("login"), request.getParameter("password")));
		if(request.getParameter("signIn") != null && table1.logIn(request.getParameter("login"), request.getParameter("password"))) {			
			String log = request.getParameter("login");
			request.setAttribute("log", log);
			forward("/UserGreeting.jsp",request,response);
		}
		else if(request.getParameter("register") != null){
			forward("/RegistrationPage.jsp", request, response);
		}
		else if(request.getParameter("registerInDB") != null){
			String log = request.getParameter("login");
			String pas = request.getParameter("password");
			String fName = request.getParameter("firstname");
			String lName = request.getParameter("lastname");
			String mail = request.getParameter("email");
			request.setAttribute("log", log);
			table1.registration(log, pas, fName, lName, mail);
			forward("/RegDone.jsp", request, response);
		}	
		else forward("/Error.jsp", request, response); 
	}
		
		
	
	public void forward(String link, HttpServletRequest request, HttpServletResponse response){
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(link);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args){
	TableDB table1 = new TableDB();
	System.out.println(table1.logIn("Lyoha", "Lyoha1"));
	}*/

}
