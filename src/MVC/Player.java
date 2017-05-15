package MVC;

public class Player {
	
/* basic abilities*/
	private String name = null;
	private int number = 0;
	private String position = null;
	// attack
	private int shotClose = 0;
	private int shotThree = 0;
	private int ballControl = 0;
	private int drawFoul = 0;
	private int freeThrow = 0;
	private int pass = 0;
	private int attConsistency = 0;
	// defence
	private int steal = 0;
	private int shotContest = 0;
	private int defConsistency = 0;
	// other
	private int rebound = 0;
	private int fatigue = 0;
	private int morale = 0;
	private int overall = 0;
	
/* match result */
	private int points = 0;
	private int fieldGoalAttemptted = 0;
	private int fieldGoalMade = 0;
	private int fieldGoalPercentage = 0;
	private int threePointsAttemptted = 0;
	private int threePointsMade = 0;
	private int threepointsPercentage = 0;
	private int freeThrowAttemptted = 0;
	private int freeThrowMade = 0;
	private int freeThrowPercentage = 0;
	private int rebounds = 0;
	private int assists = 0;
	private int steals = 0;
	private int turnovers = 0;
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getFieldGoalAttemptted() {
		return fieldGoalAttemptted;
	}
	public void setFieldGoalAttemptted(int fieldGoalAttemptted) {
		this.fieldGoalAttemptted = fieldGoalAttemptted;
	}
	public int getFieldGoalMade() {
		return fieldGoalMade;
	}
	public void setFieldGoalMade(int fieldGoalMade) {
		this.fieldGoalMade = fieldGoalMade;
	}
	public int getFieldGoalPercentage() {
		return fieldGoalPercentage;
	}
	public void setFieldGoalPercentage(int fieldGoalPercentage) {
		this.fieldGoalPercentage = fieldGoalPercentage;
	}
	public int getThreePointsAttemptted() {
		return threePointsAttemptted;
	}
	public void setThreePointsAttemptted(int threePointsAttemptted) {
		this.threePointsAttemptted = threePointsAttemptted;
	}
	public int getThreePointsMade() {
		return threePointsMade;
	}
	public void setThreePointsMade(int threePointsMade) {
		this.threePointsMade = threePointsMade;
	}
	public int getThreepointsPercentage() {
		return threepointsPercentage;
	}
	public void setThreepointsPercentage(int threepointsPercentage) {
		this.threepointsPercentage = threepointsPercentage;
	}
	public int getFreeThrowAttemptted() {
		return freeThrowAttemptted;
	}
	public void setFreeThrowAttemptted(int freeThrowAttemptted) {
		this.freeThrowAttemptted = freeThrowAttemptted;
	}
	public int getFreeThrowMade() {
		return freeThrowMade;
	}
	public void setFreeThrowMade(int freeThrowMade) {
		this.freeThrowMade = freeThrowMade;
	}
	public int getFreeThrowPercentage() {
		return freeThrowPercentage;
	}
	public void setFreeThrowPercentage(int freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}
	public int getRebounds() {
		return rebounds;
	}
	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}
	public int getSteals() {
		return steals;
	}
	public void setSteals(int steals) {
		this.steals = steals;
	}
	public int getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}
	public void setOverall(int overall) {
		this.overall = overall;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getShotClose() {
		return shotClose;
	}
	public void setShotClose(int shotClose) {
		this.shotClose = shotClose;
	}
	public int getShotThree() {
		return shotThree;
	}
	public void setShotThree(int shotThree) {
		this.shotThree = shotThree;
	}
	public int getBallControl() {
		return ballControl;
	}
	public void setBallControl(int ballControl) {
		this.ballControl = ballControl;
	}
	public int getDrawFoul() {
		return drawFoul;
	}
	public void setDrawFoul(int drawFoul) {
		this.drawFoul = drawFoul;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getAttConsistency() {
		return attConsistency;
	}
	public void setAttConsistency(int attConsistency) {
		this.attConsistency = attConsistency;
	}
	public int getSteal() {
		return steal;
	}
	public void setSteal(int steal) {
		this.steal = steal;
	}
	public int getShotContest() {
		return shotContest;
	}
	public void setShotContest(int shotContest) {
		this.shotContest = shotContest;
	}
	public int getDefConsistency() {
		return defConsistency;
	}
	public void setDefConsistency(int defConsistency) {
		this.defConsistency = defConsistency;
	}
	public int getRebound() {
		return rebound;
	}
	public void setRebound(int rebound) {
		this.rebound = rebound;
	}
	public int getFatigue() {
		return fatigue;
	}
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}
	public int getMorale() {
		return morale;
	}
	public void setMorale(int morale) {
		this.morale = morale;
	}
	public int getOverall(){
		overall = (this.shotClose + this.shotThree + this.ballControl + this.drawFoul + this.pass +this.attConsistency
				+ this.steal + this.shotContest + this.defConsistency + this.rebound + this.fatigue)/11;
		return (int) (overall*1.25);
	}
	public Player(String name, int number, String position, int shotClose, int shotThree, int ballControl, int drawFoul,
			int pass, int attConsistency, int steal, int shotContest, int defConsistency, int rebound, int fatigue,
			int morale) {
		super();
		this.name = name;
		this.number = number;
		this.position = position;
		this.shotClose = shotClose;
		this.shotThree = shotThree;
		this.ballControl = ballControl;
		this.drawFoul = drawFoul;
		this.pass = pass;
		this.attConsistency = attConsistency;
		this.steal = steal;
		this.shotContest = shotContest;
		this.defConsistency = defConsistency;
		this.rebound = rebound;
		this.fatigue = fatigue;
		this.morale = morale;
	}
	public Player(){
		
	}
	public int getFreeThrow() {
		return freeThrow;
	}
	public void setFreeThrow(int freeThrow) {
		this.freeThrow = freeThrow;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	
	
}
