package MVC;
import java.sql.*;

import org.apache.commons.dbutils.DbUtils;

public class Match {
	
	
	private int MyTeam;//my team id
	private int OpTeam;//op team id
	
	public Player[] MyStar = new Player[5];// chose my star
	public Player[] OpStar = new Player[5];// chose op star
	public int[] MyStarID = new int[5];// calculate star id in DB
	public int[] OpStarID = new int[5];// calculate star id in DB
	private int[] MyID = new int[5];// help calculate star id
	private int[] OpID = new int[5];// help calculate star id
	private Connection connection;
	public int MyTotal = 0;
	public int OpTotal = 0;
	private String[] LineUp = new String[5];
	
	public int MyTotalFGA = 0;
	public int MyTotalFGM = 0;
	public int MyTotalFGP = 0;
	public int MyTotal3A = 0;
	public int MyTotal3M = 0;
	public int MyTotal3P = 0;
	public int MyTotalFTA = 0;
	public int MyTotalFTM = 0;
	public int MyTotalFTP = 0;
	public int MyTotalRB = 0;
	public int MyTotalAS = 0;
	public int MyTotalST = 0;
	public int MyTotalTV = 0;
	
	public int OpTotalFGA = 0;
	public int OpTotalFGM = 0;
	public int OpTotalFGP = 0;
	public int OpTotal3A = 0;
	public int OpTotal3M = 0;
	public int OpTotal3P = 0;
	public int OpTotalFTA = 0;
	public int OpTotalFTM = 0;
	public int OpTotalFTP = 0;
	public int OpTotalRB = 0;
	public int OpTotalAS = 0;
	public int OpTotalST = 0;
	public int OpTotalTV = 0;
	
	
	
	//constructor1
	public Match(Connection conn,int MyTeam, int OpTeam)throws Exception{
		// pass parameter
		this.connection = conn;
		this.MyTeam = MyTeam;
		this.OpTeam = OpTeam;
		// initialize player container
		Player[] players = new Player[12];
		Player[] opponents = new Player[12];
		for(int j = 0; j<12;j++){
			players[j] = new Player();
			opponents[j] = new Player();
		}
		PreparedStatement getMyTeam = connection.prepareStatement("select * from player where partOf =?");
		PreparedStatement getOpTeam = connection.prepareStatement("select * from player where partOf =?");
		
		//warning
		SQLWarning warning = getMyTeam.getWarnings();
		if(warning!=null) System.err.println("Database Warning: "+ warning);
		try{
			getMyTeam.setInt(1, MyTeam);
			ResultSet RSmyplayer = getMyTeam.executeQuery();
			SQLWarning query_warning = getMyTeam.getWarnings();
			if(query_warning!=null) System.err.println("Query warning: "+query_warning);
			int i = 0;
			while(RSmyplayer.next()){
				
				players[i].setName(RSmyplayer.getString("name"));
				players[i].setNumber(RSmyplayer.getInt("number"));
				players[i].setPosition(RSmyplayer.getString("position"));
				//System.out.println(players[i].getName() + " " +players[i].getPosition());
				players[i].setShotClose(RSmyplayer.getInt("shotClose"));
				players[i].setShotThree(RSmyplayer.getInt("shotThree"));
				players[i].setBallControl(RSmyplayer.getInt("ballControl"));
				players[i].setDrawFoul(RSmyplayer.getInt("drawFoul"));
				players[i].setFreeThrow(RSmyplayer.getInt("freeThrow"));
				players[i].setPass(RSmyplayer.getInt("pass"));
				players[i].setAttConsistency(RSmyplayer.getInt("attackConsistency"));
				players[i].setSteal(RSmyplayer.getInt("steal"));
				players[i].setShotContest(RSmyplayer.getInt("shotContest"));
				players[i].setDefConsistency(RSmyplayer.getInt("defenceConsistency"));
				players[i].setRebound(RSmyplayer.getInt("rebound"));
				players[i].setFatigue(RSmyplayer.getInt("fatigue"));
				players[i].setMorale(RSmyplayer.getInt("morale"));
				i = i + 1;				
			}//throw new Exception("initialize Myplayer failed in team "+MyTeam);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			getMyTeam.close();
		}
		try{
			getOpTeam.setInt(1, OpTeam);
			ResultSet RSopplayer = getOpTeam.executeQuery();
			SQLWarning query_warning = getOpTeam.getWarnings();
			if(query_warning!=null) System.err.println("Query warning: "+query_warning);
			int i = 0;
			while(RSopplayer.next()){
				opponents[i].setName(RSopplayer.getString("name"));
				opponents[i].setNumber(RSopplayer.getInt("number"));
				opponents[i].setPosition(RSopplayer.getString("position"));
				opponents[i].setShotClose(RSopplayer.getInt("shotClose"));
				opponents[i].setShotThree(RSopplayer.getInt("shotThree"));
				opponents[i].setBallControl(RSopplayer.getInt("ballControl"));
				opponents[i].setDrawFoul(RSopplayer.getInt("drawFoul"));
				opponents[i].setFreeThrow(RSopplayer.getInt("freeThrow"));
				opponents[i].setPass(RSopplayer.getInt("pass"));
				opponents[i].setAttConsistency(RSopplayer.getInt("attackConsistency"));
				opponents[i].setSteal(RSopplayer.getInt("steal"));
				opponents[i].setShotContest(RSopplayer.getInt("shotContest"));
				opponents[i].setDefConsistency(RSopplayer.getInt("defenceConsistency"));
				opponents[i].setRebound(RSopplayer.getInt("rebound"));
				opponents[i].setFatigue(RSopplayer.getInt("fatigue"));
				opponents[i].setMorale(RSopplayer.getInt("morale"));
				i = i + 1;				
			}//throw new Exception ("initialize Myplayer failed in team "+OpTeam);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			getOpTeam.close();
		}
		//find starter
		
		int Mybest = 0;
		int Opbest = 0;
		for(int i = 0;i<12;i++){
			if(players[i].getName()!=null && players[i].getPosition().equals("PG") && players[i].getOverall() > Mybest){
					Mybest = players[i].getOverall();
					MyStar[0] = players[i];
					MyID[0] = i+1;
			}
			if(opponents[i].getName()!=null && opponents[i].getPosition().equals("PG") && opponents[i].getOverall() > Opbest){
				Opbest = opponents[i].getOverall();
				OpStar[0] = opponents[i];
				OpID[0] = i+1;
			}
		}
		Mybest = 0;
		Opbest = 0;
		for(int i = 0;i<12;i++){
			if(players[i].getName()!=null && players[i].getPosition().equals("SG") && players[i].getOverall() > Mybest){
					Mybest = players[i].getOverall();
					MyStar[1] = players[i];
					MyID[1] = i+1;
			}
			if(opponents[i].getName()!=null && opponents[i].getPosition().equals("SG") && opponents[i].getOverall() > Opbest){
				Opbest = opponents[i].getOverall();
				OpStar[1] = opponents[i];
				OpID[1] = i+1;
			}
		}
		Mybest = 0;
		Opbest = 0;
		for(int i = 0;i<12;i++){
			if(players[i].getName()!=null && players[i].getPosition().equals("SF") && players[i].getOverall() > Mybest){
					Mybest = players[i].getOverall();
					//System.out.println(players[i].getName() + " " +players[i].getOverall());
					MyStar[2] = players[i];
					//System.out.println(MyStar[2].getName() + " " +MyStar[2].getOverall());
					MyID[2] = i+1;
			}
			if(opponents[i].getName()!=null && opponents[i].getPosition().equals("SF") && opponents[i].getOverall() > Opbest){
				Opbest = opponents[i].getOverall();
				OpStar[2] = opponents[i];
				OpID[2] = i+1;
			}
		
		}
		Mybest = 0;
		Opbest = 0;
		for(int i = 0;i<12;i++){
			if(players[i].getName()!=null && players[i].getPosition().equals("PF") && players[i].getOverall() > Mybest){
					Mybest = players[i].getOverall();
					MyStar[3] = players[i];
					MyID[3] = i+1;
			}
			if(opponents[i].getName()!=null && opponents[i].getPosition().equals("PF") && opponents[i].getOverall() > Opbest){
				Opbest = opponents[i].getOverall();
				OpStar[3] = opponents[i];
				OpID[3] = i+1;
			}
		}
		Mybest = 0;
		Opbest = 0;
		for(int i = 0;i<12;i++){
			if(players[i].getName()!=null && players[i].getPosition().equals("C") && players[i].getOverall() > Mybest){
					Mybest = players[i].getOverall();
					MyStar[4] = players[i];
					MyID[4] = i+1;
			}
			if(opponents[i].getName()!=null && opponents[i].getPosition().equals("C") && opponents[i].getOverall() > Opbest){
				Opbest = opponents[i].getOverall();
				OpStar[4] = opponents[i];
				OpID[4] = i+1;
			}
		}		
	}// constructor end
	
	
	//constructor2
		public Match(Connection conn,int MyTeam, int OpTeam, String Line[])throws Exception{
			// pass parameter
			this.connection = conn;
			this.MyTeam = MyTeam;
			this.OpTeam = OpTeam;
			this.LineUp = Line;
			/*
			for(int i = 0 ; i < 5; i++)
				System.out.println(Line[i]);
			*/
			// initialize player container
			Player[] players = new Player[12];
			Player[] opponents = new Player[12];
			for(int j = 0; j<12;j++){
				players[j] = new Player();
				opponents[j] = new Player();
			}
			PreparedStatement getMyTeam = connection.prepareStatement("select * from player where partOf =?");
			PreparedStatement getOpTeam = connection.prepareStatement("select * from player where partOf =?");
			
			//warning
			SQLWarning warning = getMyTeam.getWarnings();
			if(warning!=null) System.err.println("Database Warning: "+ warning);
			try{
				getMyTeam.setInt(1, MyTeam);
				ResultSet RSmyplayer = getMyTeam.executeQuery();
				SQLWarning query_warning = getMyTeam.getWarnings();
				if(query_warning!=null) System.err.println("Query warning: "+query_warning);
				int i = 0;
				while(RSmyplayer.next()){
					
					players[i].setName(RSmyplayer.getString("name"));
					players[i].setNumber(RSmyplayer.getInt("number"));
					players[i].setPosition(RSmyplayer.getString("position"));
					//System.out.println(players[i].getName() + " " +players[i].getPosition());
					players[i].setShotClose(RSmyplayer.getInt("shotClose"));
					players[i].setShotThree(RSmyplayer.getInt("shotThree"));
					players[i].setBallControl(RSmyplayer.getInt("ballControl"));
					players[i].setDrawFoul(RSmyplayer.getInt("drawFoul"));
					players[i].setFreeThrow(RSmyplayer.getInt("freeThrow"));
					players[i].setPass(RSmyplayer.getInt("pass"));
					players[i].setAttConsistency(RSmyplayer.getInt("attackConsistency"));
					players[i].setSteal(RSmyplayer.getInt("steal"));
					players[i].setShotContest(RSmyplayer.getInt("shotContest"));
					players[i].setDefConsistency(RSmyplayer.getInt("defenceConsistency"));
					players[i].setRebound(RSmyplayer.getInt("rebound"));
					players[i].setFatigue(RSmyplayer.getInt("fatigue"));
					players[i].setMorale(RSmyplayer.getInt("morale"));
					i = i + 1;				
				}//throw new Exception("initialize Myplayer failed in team "+MyTeam);
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				getMyTeam.close();
			}
			try{
				getOpTeam.setInt(1, OpTeam);
				//System.out.println("OpTeam number = " +OpTeam);
				ResultSet RSopplayer = getOpTeam.executeQuery();
				SQLWarning query_warning = getOpTeam.getWarnings();
				if(query_warning!=null) System.err.println("Query warning: "+query_warning);
				int i = 0;
				while(RSopplayer.next()){
					opponents[i].setName(RSopplayer.getString("name"));
					opponents[i].setNumber(RSopplayer.getInt("number"));
					opponents[i].setPosition(RSopplayer.getString("position"));
					opponents[i].setShotClose(RSopplayer.getInt("shotClose"));
					opponents[i].setShotThree(RSopplayer.getInt("shotThree"));
					opponents[i].setBallControl(RSopplayer.getInt("ballControl"));
					opponents[i].setDrawFoul(RSopplayer.getInt("drawFoul"));
					opponents[i].setFreeThrow(RSopplayer.getInt("freeThrow"));
					opponents[i].setPass(RSopplayer.getInt("pass"));
					opponents[i].setAttConsistency(RSopplayer.getInt("attackConsistency"));
					opponents[i].setSteal(RSopplayer.getInt("steal"));
					opponents[i].setShotContest(RSopplayer.getInt("shotContest"));
					opponents[i].setDefConsistency(RSopplayer.getInt("defenceConsistency"));
					opponents[i].setRebound(RSopplayer.getInt("rebound"));
					opponents[i].setFatigue(RSopplayer.getInt("fatigue"));
					opponents[i].setMorale(RSopplayer.getInt("morale"));
					i = i + 1;				
				}//throw new Exception ("initialize Myplayer failed in team "+OpTeam);
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				getOpTeam.close();
			}
			//find starter
			
			int Mybest = 0;
			int Opbest = 0;
			for(int i = 0;i<12;i++){
				if(players[i].getName().equals(LineUp[0])){
						Mybest = players[i].getOverall();
						MyStar[0] = players[i];
						MyID[0] = i+1;
						//System.out.println(MyStar[0].getName()+":"+MyStar[0].getAttConsistency());
						break;
				}
			}
			for(int i = 0;i<12;i++){
				//System.out.println(i+":"+opponents[i].getName()+","+opponents[i].getPosition()+","+opponents[i].getOverall());
				if(opponents[i].getName()!=null && opponents[i].getPosition().equals("PG") && opponents[i].getOverall() > Opbest){
					Opbest = opponents[i].getOverall();
					OpStar[0] = opponents[i];
					OpID[0] = i+1;
				}
			}
			Mybest = 0;
			Opbest = 0;
			for(int i = 0;i<12;i++){
				if(players[i].getName().equals(LineUp[1])){
						Mybest = players[i].getOverall();
						MyStar[1] = players[i];
						MyID[1] = i+1;
						//System.out.println(MyStar[1].getName()+":"+MyStar[1].getAttConsistency());
						break;
				}
			}
			for(int i = 0;i<12;i++){
				if(opponents[i].getName()!=null && opponents[i].getPosition().equals("SG") && opponents[i].getOverall() > Opbest){
					Opbest = opponents[i].getOverall();
					OpStar[1] = opponents[i];
					OpID[1] = i+1;
					
				}
			}
			Mybest = 0;
			Opbest = 0;
			for(int i = 0;i<12;i++){
				if(players[i].getName().equals(LineUp[2])){
						Mybest = players[i].getOverall();
						//System.out.println(players[i].getName() + " " +players[i].getOverall());
						MyStar[2] = players[i];
						//System.out.println(MyStar[2].getName() + " " +MyStar[2].getOverall());
						MyID[2] = i+1;
						//System.out.println(MyStar[2].getName()+":"+MyStar[2].getAttConsistency());
						break;
				}
			}
			for(int i = 0;i<12;i++){
				if(opponents[i].getName()!=null && opponents[i].getPosition().equals("SF") && opponents[i].getOverall() > Opbest){
					Opbest = opponents[i].getOverall();
					OpStar[2] = opponents[i];
					OpID[2] = i+1;
					
				}
			
			}
			Mybest = 0;
			Opbest = 0;
			for(int i = 0;i<12;i++){
				if(players[i].getName().equals(LineUp[3])){
						Mybest = players[i].getOverall();
						MyStar[3] = players[i];
						MyID[3] = i+1;
						//System.out.println(MyStar[3].getName()+":"+MyStar[3].getAttConsistency());
						break;
				}
			}
			for(int i = 0;i<12;i++){
				if(opponents[i].getName()!=null && opponents[i].getPosition().equals("PF") && opponents[i].getOverall() > Opbest){
					Opbest = opponents[i].getOverall();
					OpStar[3] = opponents[i];
					OpID[3] = i+1;
					
				}
			}
			Mybest = 0;
			Opbest = 0;
			for(int i = 0;i<12;i++){
				if(players[i].getName().equals(LineUp[4])){
						Mybest = players[i].getOverall();
						MyStar[4] = players[i];
						MyID[4] = i+1;
						//System.out.println(MyStar[4].getName()+":"+MyStar[4].getAttConsistency());
						break;
				}
			}
			for(int i = 0;i<12;i++){
				if(opponents[i].getName()!=null && opponents[i].getPosition().equals("C") && opponents[i].getOverall() > Opbest){
					Opbest = opponents[i].getOverall();
					OpStar[4] = opponents[i];
					OpID[4] = i+1;
				}
			}		
		}// constructor end
	public void getStats() throws Exception{
			//match
		
			for(int i = 0 ; i <5; i++){
			int advantage = -1; 
			if(MyStar[i].getAttConsistency()>OpStar[i].getDefConsistency())
				advantage = 1;
			double powerup = (double)(MyStar[i].getMorale()/50);
			// steal & turnover
			int steal = 0;
			if(MyStar[i].getSteal()*1.5 > OpStar[i].getBallControl()){
				steal = Math.max(0, ((int)(MyStar[i].getSteal()*1.5) - OpStar[i].getBallControl())/10);
				steal = (int)((steal+1)*Math.random());
			}
			MyStar[i].setSteals(steal);
			OpStar[i].setTurnovers(steal);
				
			// goal attemptted
			int goalAttemppted = Math.max(0, MyStar[i].getAttConsistency()/5+(int)(11*Math.random()-5 + advantage*(int)(4*Math.random()+steal)));
			int close = 0;
			int three = 0;
			close = Math.min(goalAttemppted, Math.max(0, ((int)(goalAttemppted * (double)MyStar[i].getShotClose()/MyStar[i].getShotThree())-goalAttemppted/4+(int)((goalAttemppted/2+1)*Math.random()))));
			three = goalAttemppted - close;
			//System.out.println(MyStar[i].getName() + " fieldgoal: "+goalAttemppted + " two points: "+close);
			MyStar[i].setFieldGoalAttemptted(goalAttemppted);  
			MyStar[i].setThreePointsAttemptted(three);
			
			// goal made
			double rate2 = Math.max(0, Math.min(100, MyStar[i].getShotClose()*powerup-10+(int)(21*Math.random())));
			int made2 = (int)(close * rate2/100);
			float rate3 = (float) Math.max(0, Math.min(100, MyStar[i].getShotThree()*powerup-(MyStar[i].getShotThree()-OpStar[i].getShotContest())/2+(int)((MyStar[i].getShotThree()-OpStar[i].getShotContest())*Math.random())));
			int made3 = (int)(three * rate3/100);
			MyStar[i].setFieldGoalMade(made2+made3);
			MyStar[i].setThreePointsMade(made3);
			if (goalAttemppted==0)
				MyStar[i].setFieldGoalPercentage(0);
			else{
				int FGP = (made2+made3)*100/goalAttemppted;
				MyStar[i].setFieldGoalPercentage(FGP);
			}
			if(three==0)
				MyStar[i].setThreepointsPercentage(0);
			else
				MyStar[i].setThreepointsPercentage(made3*100/three);
			
			// draw foul
			int foul = 0;
			int foul2 = 0;
			int foul3 = 0;
			foul = MyStar[i].getDrawFoul()/10+(int)(4*Math.random());
			foul = (int)((foul+1)*Math.random());
			foul3 = Math.min(2, (int)((foul+1)*Math.random()));
			foul2 = foul-foul3;
			int FTattemptted = foul2*2+foul3*3;
			MyStar[i].setFreeThrowAttemptted(FTattemptted);
			float FTrate = (float) Math.min(100, (float)(MyStar[i].getFreeThrow())-20+40*Math.random());
			
			int FTmade = (int)(FTattemptted*FTrate/100);
			MyStar[i].setFreeThrowMade(FTmade);
			if(FTmade == 0) 
				MyStar[i].setFreeThrowPercentage(0);
			else{
				int FTP = FTmade*100/FTattemptted;
				MyStar[i].setFreeThrowPercentage(FTP);
			}
			
			// Totoal score
			int points = made2*2+made3*3+FTmade;
			MyStar[i].setPoints(points);
			
			// Rebound and Assisit
			int assists = Math.max(0, (int)(MyStar[i].getPass()/10*powerup-3+(int)(7*Math.random())));
			int rebounds = Math.max(0, (int)(MyStar[i].getRebound()/10*powerup-4+(int)(9*Math.random())));
		
			MyStar[i].setAssists(assists);
			MyStar[i].setRebounds(rebounds);
			
			MyStarID[i] = (MyTeam-1)*12+MyID[i];
		}
		
		//opponents
		for(int i = 0 ; i <5; i++){
			int advantage = -1; 
			if(OpStar[i].getAttConsistency()>MyStar[i].getDefConsistency())
				advantage = 1;
			double powerup = (double)(OpStar[i].getMorale()/50);
			// steal & turnover
			int steal = 0;
			if(OpStar[i].getSteal()*1.5 > MyStar[i].getBallControl()){
				steal = Math.max(0, ((int)(OpStar[i].getSteal()*1.5) - MyStar[i].getBallControl())/10);
				steal = (int)((steal+1)*Math.random());
			}
			OpStar[i].setSteals(steal);
			MyStar[i].setTurnovers(steal);
				
			// goal attemptted
			int goalAttemppted = Math.max(0, OpStar[i].getAttConsistency()/5+(int)(11*Math.random()-5 + advantage*(int)(4*Math.random()+steal)));
			int close = 0;
			int three = 0;
			close = Math.min(goalAttemppted, Math.max(0, ((int)(goalAttemppted * (double)OpStar[i].getShotClose()/OpStar[i].getShotThree())-goalAttemppted/4+(int)((goalAttemppted/2+1)*Math.random()))));
			three = goalAttemppted - close;
			OpStar[i].setFieldGoalAttemptted(goalAttemppted);  
			OpStar[i].setThreePointsAttemptted(three);
			
			// goal made
			float rate2 = (float) Math.max(0, Math.min(100, OpStar[i].getShotClose()*powerup-10+(int)(21*Math.random())));
			int made2 = (int)(close * rate2/100);
			float rate3 = (float) Math.max(0, Math.min(100, OpStar[i].getShotThree()*powerup-(OpStar[i].getShotThree()-MyStar[i].getShotContest())/2+(int)((OpStar[i].getShotThree()-MyStar[i].getShotContest())*Math.random())));
			int made3 = (int)(three * rate3/100);
			OpStar[i].setFieldGoalMade(made2+made3);
			OpStar[i].setThreePointsMade(made3);
			if (goalAttemppted==0)
				OpStar[i].setFieldGoalPercentage(made2+made3);
			else{
				int FGP = (made2+made3)*100/goalAttemppted;
				OpStar[i].setFieldGoalPercentage(FGP);
			}
			if(three==0)	
				OpStar[i].setThreepointsPercentage(0);
			else
				OpStar[i].setThreepointsPercentage(made3*100/three);
			
			// draw foul
			int foul = 0;
			int foul2 = 0;
			int foul3 = 0;
			foul = OpStar[i].getDrawFoul()/10+(int)(4*Math.random());
			foul = (int)((foul+1)*Math.random());
			foul3 = Math.min(2, (int)((foul+1)*Math.random()));
			foul2 = foul-foul3;
			int FTattemptted = foul2*2+foul3*3;
			OpStar[i].setFreeThrowAttemptted(FTattemptted);
			float FTrate = (float) Math.min(100, (float)(OpStar[i].getFreeThrow())-20+40*Math.random());
			
			int FTmade = Math.round((FTattemptted*FTrate/100));
			OpStar[i].setFreeThrowMade(FTmade);
			if (FTmade ==0)
				OpStar[i].setFreeThrowPercentage(0);
			else{
				int FTP = FTmade*100/FTattemptted;
				OpStar[i].setFreeThrowPercentage(FTP);
			}
			
			// Totoal score
			int points = made2*2+made3*3+FTmade;
			OpStar[i].setPoints(points);
			
			// Rebound and Assisit
			int assists = (int)(OpStar[i].getPass()/10*powerup+(int)(6*Math.random()));
			int rebounds = (int)(OpStar[i].getRebound()/10*powerup+(int)(6*Math.random()));
			
			assists = (int)((assists+1)*Math.random()+(int)(3*Math.random()));
			rebounds = (int)((rebounds+1)*Math.random()+(int)(3*Math.random()));
			OpStar[i].setAssists(assists);
			OpStar[i].setRebounds(rebounds);
			
			OpStarID[i] = (OpTeam-1)*12+OpID[i];
			
		}	
		// stats
		
				//System.out.println("Myteam("+MyTeam+"):");
				for(int i = 0; i < 5; i++)
				{	
					MyTotal = MyTotal +MyStar[i].getPoints();
					MyTotalFGA = MyTotalFGA + MyStar[i].getFieldGoalAttemptted();
					MyTotalFGM = MyTotalFGM + MyStar[i].getFieldGoalMade();
					if(MyTotalFGA ==0) MyTotalFGP = 0;
					else MyTotalFGP = MyTotalFGM*100/MyTotalFGA;
					MyTotal3A = MyTotal3A + MyStar[i].getThreePointsAttemptted();
					MyTotal3M = MyTotal3M + MyStar[i].getThreePointsMade();
					if(MyTotal3A ==0) MyTotal3P = 0;
					else MyTotal3P = MyTotal3M*100/MyTotal3A;
					MyTotalFTA = MyTotalFTA + MyStar[i].getFreeThrowAttemptted();
					MyTotalFTM = MyTotalFTM + MyStar[i].getFreeThrowMade();
					if(MyTotalFTA ==0) MyTotalFTP = 0;
					else MyTotalFTP = MyTotalFTM*100/MyTotalFTA;
					MyTotalRB = MyTotalRB + MyStar[i].getRebounds();
					MyTotalAS = MyTotalAS + MyStar[i].getAssists();
					MyTotalST = MyTotalST + MyStar[i].getSteals();
					MyTotalTV = MyTotalTV + MyStar[i].getTurnovers();
					
				}
				//System.out.println("Opponents("+OpTeam+"):");
				for(int i = 0; i < 5; i++){
					OpTotal = OpTotal +OpStar[i].getPoints();
					OpTotalFGA = OpTotalFGA + OpStar[i].getFieldGoalAttemptted();
					OpTotalFGM = OpTotalFGM + OpStar[i].getFieldGoalMade();
					if(OpTotalFGA ==0) OpTotalFGP = 0;
					else OpTotalFGP = OpTotalFGM*100/OpTotalFGA;
					OpTotal3A = OpTotal3A + OpStar[i].getThreePointsAttemptted();
					OpTotal3M = OpTotal3M + OpStar[i].getThreePointsMade();
					if(OpTotal3A ==0) OpTotal3P = 0;
					else OpTotal3P = OpTotal3M*100/OpTotal3A;
					OpTotalFTA = OpTotalFTA + OpStar[i].getFreeThrowAttemptted();
					OpTotalFTM = OpTotalFTM + OpStar[i].getFreeThrowMade();
					if(OpTotalFTA ==0) OpTotalFTP = 0;
					else OpTotalFTP = OpTotalFTM*100/OpTotalFTA;
					OpTotalRB = OpTotalRB + OpStar[i].getRebounds();
					OpTotalAS = OpTotalAS + OpStar[i].getAssists();
					OpTotalST = OpTotalST + OpStar[i].getSteals();
					OpTotalTV = OpTotalTV + OpStar[i].getTurnovers();
					
				}
				PreparedStatement updateStatics;
				String update = "update statistics set points=?,fieldGoalAttemptted=?,fieldGoalMade=?,fieldGoalPercentage=?,3pointsAttemptted=?,3pointsMade=?,3pointsPercentage=?,freeThrowAttemptted=?,freeThrowMade=?,freeThrowPercentage=?,rebounds=?,assists=?,steals=?,turnovers=? where id=?";
				updateStatics = this.connection.prepareStatement(update);
				SQLWarning warning = updateStatics.getWarnings();
				if(warning != null) System.err.println("Database Warning: "+warning);
				try{
					for(int i = 0; i < 5; i++)//update my team
					{	
						
						updateStatics.setInt(1, MyStar[i].getPoints());
						updateStatics.setInt(2, MyStar[i].getFieldGoalAttemptted());
						updateStatics.setInt(3, MyStar[i].getFieldGoalMade());
						updateStatics.setInt(4, MyStar[i].getFieldGoalPercentage());
						updateStatics.setInt(5, MyStar[i].getThreePointsAttemptted());
						updateStatics.setInt(6, MyStar[i].getThreePointsMade());
						updateStatics.setInt(7, MyStar[i].getThreepointsPercentage());
						updateStatics.setInt(8, MyStar[i].getFreeThrowAttemptted());
						updateStatics.setInt(9, MyStar[i].getFreeThrowMade());
						updateStatics.setInt(10, MyStar[i].getFreeThrowPercentage());
						updateStatics.setInt(11, MyStar[i].getRebounds());
						updateStatics.setInt(12, MyStar[i].getAssists());
						updateStatics.setInt(13, MyStar[i].getSteals());
						updateStatics.setInt(14, MyStar[i].getTurnovers());
						updateStatics.setInt(15, MyStarID[i]);
						
						int updateCount = updateStatics.executeUpdate();
						SQLWarning updateWarning = updateStatics.getWarnings();
						if(updateWarning != null) System.err.println("update warning "+updateWarning);
						if(updateCount != 1) throw new Exception("No id was found: "+MyStarID[i]);
					}
					
					for(int i = 0; i < 5; i++)//update op team
					{
						updateStatics.setInt(1, OpStar[i].getPoints());
						updateStatics.setInt(2, OpStar[i].getFieldGoalAttemptted());
						updateStatics.setInt(3, OpStar[i].getFieldGoalMade());
						updateStatics.setInt(4, OpStar[i].getFieldGoalPercentage());
						updateStatics.setInt(5, OpStar[i].getThreePointsAttemptted());
						updateStatics.setInt(6, OpStar[i].getThreePointsMade());
						updateStatics.setInt(7, OpStar[i].getThreepointsPercentage());
						updateStatics.setInt(8, OpStar[i].getFreeThrowAttemptted());
						updateStatics.setInt(9, OpStar[i].getFreeThrowMade());
						updateStatics.setInt(10, OpStar[i].getFreeThrowPercentage());
						updateStatics.setInt(11, OpStar[i].getRebounds());
						updateStatics.setInt(12, OpStar[i].getAssists());
						updateStatics.setInt(13, OpStar[i].getSteals());
						updateStatics.setInt(14, OpStar[i].getTurnovers());
						updateStatics.setInt(15, OpStarID[i]);
						int updateCount = updateStatics.executeUpdate();
						SQLWarning updateWarning = updateStatics.getWarnings();
						if(updateWarning != null) System.err.println("update warning "+updateWarning);
						if(updateCount != 1) throw new Exception("No id was found: "+MyStarID[i]);
					}
					
				}finally{
					DbUtils.closeQuietly(updateStatics);
				}
				// clear off
				
	}
	public void clearOff() throws Exception{
		PreparedStatement ClearStatics;
		String clear = "update statistics set points=?,fieldGoalAttemptted=?,fieldGoalMade=?,fieldGoalPercentage=?,3pointsAttemptted=?,3pointsMade=?,3pointsPercentage=?,freeThrowAttemptted=?,freeThrowMade=?,freeThrowPercentage=?,rebounds=?,assists=?,steals=?,turnovers=? where id is not null";
		ClearStatics = this.connection.prepareStatement(clear);
		SQLWarning warningClear = ClearStatics.getWarnings();
		if(warningClear != null) System.err.println("Database Warning: "+warningClear);
		int Clear = 0;
		try{
			for(int i = 0; i < 5; i++)//update my team
			{	
				
				ClearStatics.setInt(1, Clear);
				ClearStatics.setInt(2, Clear);
				ClearStatics.setInt(3, Clear);
				ClearStatics.setInt(4, Clear);
				ClearStatics.setInt(5, Clear);
				ClearStatics.setInt(6, Clear);
				ClearStatics.setInt(7, Clear);
				ClearStatics.setInt(8, Clear);
				ClearStatics.setInt(9, Clear);
				ClearStatics.setInt(10, Clear);
				ClearStatics.setInt(11, Clear);
				ClearStatics.setInt(12, Clear);
				ClearStatics.setInt(13, Clear);
				ClearStatics.setInt(14, Clear);
				
				
				int updateCount = ClearStatics.executeUpdate();
				SQLWarning updateWarning = ClearStatics.getWarnings();
				if(updateWarning != null) System.err.println("update warning "+updateWarning);
				if(updateCount != 1) throw new Exception("Cannot clear off");
			}
			
		}finally{
			DbUtils.closeQuietly(ClearStatics);
		}
	}
	
	
}
