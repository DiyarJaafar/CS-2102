
public class RoboticsTeam implements IContestant {
	String school;
	String feature;
	int previousScore;
	
	public RoboticsTeam (String school, String feature, int previousScore) {
		this.school = school;
		this.feature = feature;
		this.previousScore = previousScore;
		}
	
	// expectToBeat consumes the roboticsTeam
	// and produces true if its previousScore is greater than the parameter's
	// false otherwise
	public boolean expectToBeat (RoboticsTeam anotherContestant) {
		return (this.previousScore > anotherContestant.previousScore);
	}
	
}
