import java.util.LinkedList;

public class InitRound extends AbsRound{

	
	public InitRound (LinkedList<Match> matches) {
		super(matches);
		
	}
	
	/*
	 * Takes in an IContestant and
	 * returns true if the contestant was a winner in at least one of the matches
	 */
	public boolean isWinner(IContestant winner) {
		for (IContestant contestants : this.getMatchWinners()) {
			if (contestants.equals(winner)) {
				return true;
			}
		}
		return false;
	}

}
