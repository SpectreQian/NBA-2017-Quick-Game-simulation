package MVC;

import java.sql.*;
import org.apache.commons.dbutils.DbUtils;

public class ApplicationsDAO {

	public static void main(String[] args) {
		/*ApplicationsDAO dao = new ApplicationsDAO();
		Connection connection = dao.getConnection();
		dao.closeConnection(connection);
		*/
		
		//initialize players container
		
		//connect to DB
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:1115/nba2017?useSSL=false","root","lulu0907");
			int MyTeam = 5;
			int OpTeam = 2;
			try {
				Match match = new Match(conn,MyTeam,OpTeam);
				match.getStats();
				if(match.MyTotal>match.OpTotal) System.out.println(match.MyTotal+":"+match.OpTotal+"\nYou Win!");
				else if (match.MyTotal==match.OpTotal) System.out.println(match.MyTotal+":"+match.OpTotal+"\nDraw Game!");
				else System.out.println(match.MyTotal+":"+match.OpTotal+"\nYou Lose!");
				//match.MyStar[5].getAssists();
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
