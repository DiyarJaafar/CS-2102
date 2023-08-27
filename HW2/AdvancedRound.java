import java.util.LinkedList;


public class AdvancedRound extends AbsRound{
	LinkedList <IContestant> contestants = new LinkedList <IContestant>();

	public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
		super(matches);
		this.contestants = contestants;
		
	}
	
	/*
	 * Gets the list of winners
	 * returns a LinkedList of all of the contestants that won each match in each round
	 */
	public LinkedList<IContestant> getMatchWinners() {
		for (Match aMatch : this.matches) {
			contestants.add(aMatch.winner());
		}
		return contestants;
		}
	
	/*
	 * Takes in an IContestant and
	 * returns whether that contestant was one of the winners from the previous round
	 */
	public boolean isWinner(IContestant winner) {
			for (IContestant contestants : this.contestants) {
				if (contestants.equals(winner))
					return true;
		}
		return false;
	}
}
