package MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int MyTeam;
	public static int OpTeam; 
	public static String myteam;
	public static String opteam;
	public String test = "Test case";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myteam = request.getParameter("MyTeam");
		opteam = request.getParameter("OpTeam");
		MyTeam = TeamChose(myteam);
		OpTeam = TeamChose(opteam);
		
		if(MyTeam==1)	response.sendRedirect("/WebAPP/HawksChoseLineUp.jsp");
		else if(MyTeam==2)	response.sendRedirect("/WebAPP/HawksChoseLineUp.jsp");
		else if(MyTeam==3)	response.sendRedirect("/WebAPP/HawksChoseLineUp.jsp");
		else if(MyTeam==4)	response.sendRedirect("/WebAPP/HawksChoseLineUp.jsp");
		else if(MyTeam==5)	response.sendRedirect("/WebAPP/HawksChoseLineUp.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private int TeamChose(String team){
		if(team.equals("Atlanda Hawwks"))return 1;
		else if(team.equals("Boston Celtics"))return 2;
		else if(team.equals("Brooklvn Nets"))return 3;
		else if(team.equals("Charlotte Hornets"))return 4;
		else if(team.equals("Chicago Bulls"))return 5;
		return 0;		
	}

}
