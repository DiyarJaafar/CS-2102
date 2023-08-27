import java.util.LinkedList;

public abstract class AbsRound implements IWinner{
	LinkedList<Match> matches = new LinkedList<Match>();
	
	public AbsRound (LinkedList<Match> matches) {
		this.matches = matches;
	}
	
	/*
	 * Gets the list of winners
	 * returns a LinkedList of all of the contestants that won each match in each round
	 */
	public LinkedList<IContestant> getMatchWinners() {
		LinkedList<IContestant> listOfWinners = new LinkedList<IContestant>();
		for (Match aMatch : this.matches) {
			listOfWinners.add(aMatch.winner());
		}
		return listOfWinners;
	}
	
	/*
	 * Gets the list of winners
	 * returns the number of winners in the round
	 */
	public int getNumWinners() {
		int wins = 0;
		for (IContestant winner : this.getMatchWinners()) {
			wins++;
		}
		return wins;
	}

}
