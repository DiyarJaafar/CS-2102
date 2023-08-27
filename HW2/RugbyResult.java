public class RugbyResult implements IResult {

	double team1points;
	double team2points;
	IContestant rugTeam1;
	IContestant rugTeam2;
	
	public RugbyResult (IContestant rugTeam1, IContestant rugTeam2, double team1points, double team2points) {
		this.rugTeam1 = rugTeam1;
		this.rugTeam2 = rugTeam2;
		this.team1points = team1points;
		this.team2points = team2points;
	}
	
	// isValid() produces IResult
	// produces true if the RoboticsResult is valid
	// false otherwise
	public boolean isValid () {
		return (team1points < 150 && team2points < 150); 
	}
	
	
	// getWinner() consumes result
	// produces the the winner by comparing two teams' scores
	public IContestant getWinner () {
		if (this.team1points > this.team2points) {
			return rugTeam1;
		}
		else
			return rugTeam2;
	}

}
