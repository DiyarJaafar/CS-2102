
public class RugbyTeam implements IContestant{
	String country;
	String color;
	boolean ritual;
	int wins;
	int losses;
	
	public RugbyTeam (String country, String color, boolean ritual, int wins, int losses) {
		this.country = country;
		this.color = color;
		this.ritual = ritual;
		this.wins = wins;
		this.losses = losses;
	}
	
	// expectToBeat consumes the rugbyTeam
	// if only one team has a ritual, that team is the winner
	// if neither or both have rituals, the winner is
	// the one with the bigger gap between number of wins and losses
	// produces true if it (this) is expected to win
	// false otherwise (i.e. parameter team is expected to win)
	public boolean expectToBeat (RugbyTeam anotherContestant) {
		if (this.ritual && anotherContestant.ritual == false) {
			return true;
		}
		else 
			return (this.wins - this.losses) > (anotherContestant.wins - anotherContestant.losses);
	}
}
