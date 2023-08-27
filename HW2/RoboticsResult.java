
public class RoboticsResult implements IResult{
	
	IContestant robTeam1;
	IContestant robTeam2;
	double team1points;
	double team1tasks;
	boolean team1fell;
	double team2points;
	double team2tasks;
	boolean team2fell;
	
	public RoboticsResult(IContestant robTeam1, IContestant robTeam2, double team1points, double team1tasks,
	boolean team1fell, double team2points, double team2tasks, boolean team2fell) {
		this.robTeam1 = robTeam1;
		this.robTeam2 = robTeam2;
		this.team1points = team1points;
		this.team1tasks = team1tasks;
		this.team1fell = team1fell;
		this.team2points = team2points;
		this.team2tasks = team2tasks;
		this.team2fell = team2fell;
	}
	
	// isValid() produces IResult
	// produces true if the RoboticsResult is valid
	// false otherwise
	public boolean isValid () {
		return (team1tasks < 8 && team2tasks < 8 && team1points < 16 && team2points < 16); 
	}
	
	// getScore consumes double teampoints, double teamtasks, and boolean teamfell
	// and produces the score the team got depending on whether its robot fell or not
	public double getScore (double teampoints, double teamtasks, boolean teamfell) {
		if (teamfell == true) {
			return (teamtasks + teampoints - 5);
		}
		else 
			return (teamtasks + teampoints);
	}
	
	// getWinner() consumes result
	// produces the the winner by comparing two teams' scores
	public IContestant getWinner() {
		if (this.getScore(this.team1tasks, this.team1points, this.team1fell) >  
		(this.getScore(this.team2tasks, this.team2points, this.team2fell))) {
			return robTeam1;
		}
		else 
			return robTeam2;
	}
}