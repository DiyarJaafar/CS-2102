import java.util.LinkedList;

public class Tournament {
	LinkedList<IWinner> rounds = new LinkedList<IWinner>();
	
	public Tournament (LinkedList<IWinner> rounds) {
		this.rounds = rounds;
		
	}
	
	
	/*
	 * Takes in a contestant representing the tournament winner and
	 * returns true if the contestant is a valid winner
	 * the contestant is a valid winner if she/she has won at least half of the rounds
	 */
	public boolean finalWinnerIsValid(IContestant tournamentWinner) {
		int number = 0;
		for (IWinner aRound : rounds) {
			if (aRound.isWinner(tournamentWinner)) 
				number++;
		}
		if (number >= rounds.size()/2) {
			return true;
		}
			return false;
	}
	
	public void add (IWinner addIt) {
		this.rounds.add(addIt);
	}
}
