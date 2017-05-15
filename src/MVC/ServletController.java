package MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.DbUtils;
import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class ServletController
 */
@WebServlet(urlPatterns = "/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
    Class.forName("com.mysql.jdbc.Driver").newInstance();
	String connectionUrl = "jdbc:mysql://localhost:1115/MVC";
	connection = DriverManager.getConnection(connectionUrl,"root",null);
    */
    /**
     * @see HttpServlet#HttpServlet()
     */
 
    public ServletController() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int MyTeam = TeamServlet.MyTeam;
		int OpTeam = TeamServlet.OpTeam;
		int MyLineUp = 0;
		String[] LineUp= new String[5];
		
		if(request.getParameter("Radios") != null) {
             if(request.getParameter("Radios").equals("Use Default LineUp")) ;
             else {
            	 MyLineUp = 1;
            	 LineUp[0] = request.getParameter("PG");
            	 LineUp[1] = request.getParameter("SG");
            	 LineUp[2] = request.getParameter("SF");
            	 LineUp[3] = request.getParameter("PF");
            	 LineUp[4] = request.getParameter("C");
            	 }
             }
		System.out.println(LineUp[0]);
		
		response.setContentType("text/html");
    	PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
    	Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:1115/nba2017?useSSL=false","root","lulu0907");
			
			try {
				Match match;
				if(MyLineUp == 0){	
					match = new Match(conn,MyTeam,OpTeam);
					match.getStats();
				}
				else{
					match = new Match(conn,MyTeam,OpTeam,LineUp);
					match.getStats();
				}
				if(match.MyTotal>match.OpTotal) out.println("<h3>"+match.MyTotal+":"+match.OpTotal+"\nYou Win!"+"</h3>");
				else if (match.MyTotal==match.OpTotal) out.println("<h3>"+match.MyTotal+":"+match.OpTotal+"\nDraw Game!"+"</h3>");
				else out.println("<h3>"+match.MyTotal+":"+match.OpTotal+"\nYou Lose!"+"</h3>");
				
				out.println("<body style=\"background:url('image/Results.jpg');background-size:cover\">");
				//MyTeamPlayer	
				out.println("<h1>Score Box</h1><h3>"+TeamServlet.myteam+"</h3><table border = '2'><tbody>"
						+"<tr><td>Name</td><td>Points</td><td>Goal/Attemppted</td><td>Percentage</td>"
						+"<td>Three Goal/Attemppted</td><td>Percentage</td><td>FT Goal/Attempped</td><td>percentage</td>"
						+"<td>Rebound</td><td>Assists</td><td>Steals</td><td>Turnover</td></tr>");
				
				for(int i = 0;i < 5; i++){
					out.println("<tr><td>"+match.MyStar[i].getName()+"</td>"
							+"<td>"+match.MyStar[i].getPoints()+"</td>"
							+"<td>"+match.MyStar[i].getFieldGoalMade()+"/"+match.MyStar[i].getFieldGoalAttemptted()+"</td>"
							+"<td>"+match.MyStar[i].getFieldGoalPercentage()+"%</td>"
							+"<td>"+match.MyStar[i].getThreePointsMade()+"/"+match.MyStar[i].getThreePointsAttemptted()+"</td>"
							+"<td>"+match.MyStar[i].getThreepointsPercentage()+"%</td>"
							+"<td>"+match.MyStar[i].getFreeThrowMade()+"/"+match.MyStar[i].getFreeThrowAttemptted()+"</td>"
							+"<td>"+match.MyStar[i].getFreeThrowPercentage()+"%</td>"
							+"<td>"+match.MyStar[i].getRebounds()+"</td>"
							+"<td>"+match.MyStar[i].getAssists()+"</td>"
							+"<td>"+match.MyStar[i].getSteals()+"</td>"
							+"<td>"+match.MyStar[i].getTurnovers()+"</td>"
							+"</tr>");
				}
				out.println("<tr><td>Total</td>"
						+"<td>"+match.MyTotal+"</td>"
						+"<td>"+match.MyTotalFGM+"/"+match.MyTotalFGA+"</td>"
						+"<td>"+match.MyTotalFGP+"%</td>"
						+"<td>"+match.MyTotal3M+"/"+match.MyTotal3A+"</td>"
						+"<td>"+match.MyTotal3P+"%</td>"
						+"<td>"+match.MyTotalFTM+"/"+match.MyTotalFTA+"</td>"
						+"<td>"+match.MyTotalFTP+"%</td>"
						+"<td>"+match.MyTotalRB+"</td>"
						+"<td>"+match.MyTotalAS+"</td>"
						+"<td>"+match.MyTotalST+"</td>"
						+"<td>"+match.MyTotalTV+"</td>"
						+"</tr>");
				out.println("</tbody></table>");
				//Opteam
				out.println("<h3>"+TeamServlet.opteam+"</h3><table border = '2'><tbody>"
						+"<tr><td>Name</td><td>Points</td><td>Goal/Attemppted</td><td>Percentage</td>"
						+"<td>Three Goal/Attemppted</td><td>Percentage</td><td>FT Goal/Attempped</td><td>percentage</td>"
						+"<td>Rebound</td><td>Assists</td><td>Steals</td><td>Turnover</td></tr>");
				
				for(int i = 0;i < 5; i++){
					out.println("<tr><td>"+match.OpStar[i].getName()+"</td>"
							+"<td>"+match.OpStar[i].getPoints()+"</td>"
							+"<td>"+match.OpStar[i].getFieldGoalMade()+"/"+match.OpStar[i].getFieldGoalAttemptted()+"</td>"
							+"<td>"+match.OpStar[i].getFieldGoalPercentage()+"%</td>"
							+"<td>"+match.OpStar[i].getThreePointsMade()+"/"+match.OpStar[i].getThreePointsAttemptted()+"</td>"
							+"<td>"+match.OpStar[i].getThreepointsPercentage()+"%</td>"
							+"<td>"+match.OpStar[i].getFreeThrowMade()+"/"+match.OpStar[i].getFreeThrowAttemptted()+"</td>"
							+"<td>"+match.OpStar[i].getFreeThrowPercentage()+"%</td>"
							+"<td>"+match.OpStar[i].getRebounds()+"</td>"
							+"<td>"+match.OpStar[i].getAssists()+"</td>"
							+"<td>"+match.OpStar[i].getSteals()+"</td>"
							+"<td>"+match.OpStar[i].getTurnovers()+"</td>"
							+"</tr>");
				}
				out.println("<tr><td>Total</td>"
						+"<td>"+match.OpTotal+"</td>"
						+"<td>"+match.OpTotalFGM+"/"+match.OpTotalFGA+"</td>"
						+"<td>"+match.OpTotalFGP+"%</td>"
						+"<td>"+match.OpTotal3M+"/"+match.OpTotal3A+"</td>"
						+"<td>"+match.OpTotal3P+"%</td>"
						+"<td>"+match.OpTotalFTM+"/"+match.OpTotalFTA+"</td>"
						+"<td>"+match.OpTotalFTP+"%</td>"
						+"<td>"+match.OpTotalRB+"</td>"
						+"<td>"+match.OpTotalAS+"</td>"
						+"<td>"+match.OpTotalST+"</td>"
						+"<td>"+match.OpTotalTV+"</td>"
						+"</tr>");
				out.println("</tbody></table></body>");
				
				
				
				//match.clearOff();
				
				out.println("<form name = 'BackIndex' action = '/WebAPP/Index.jsp' method = 'post'>");
				out.println("<input type = 'submit' value = 'Back to index' name = 'comform'/>");
				out.println("</form>");
			} catch (Exception e) {				
				e.printStackTrace();
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		
	}
}
