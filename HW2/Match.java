
public class Match {
	IContestant contestant1;
	IContestant contestant2;
	IResult result;
	
	public Match (IContestant contestant1, IContestant contestant2, IResult result) {
		this.contestant1 = contestant1;
		this.contestant2 = contestant2;
		this.result = result;
	}
	
	// winner() consumes a match
	// and produces the winner if the result is valid
	// if it not valid, it produces null
	public IContestant winner() {
		if (this.result.isValid()) {
			return this.result.getWinner();
		}
		else
			return null;
	}



}
