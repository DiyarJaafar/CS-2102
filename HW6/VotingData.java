import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class VotingData {

    private LinkedList<String> ballot = new LinkedList<String>(); //List of eligible candidates
    private HashMap<String, Integer> firstVotes = new HashMap<String, Integer>(); //Each candidate's first choice votes
    private HashMap<String, Integer> secondVotes = new HashMap<String, Integer>(); //Each candidate's second choice votes
    private HashMap<String, Integer> thirdVotes = new HashMap<String, Integer>(); //Each candidate's third choice votes

    VotingData() {
    }
    /**
     * Prints out the ballot
     */
    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : ballot) {
            System.out.println(s);
        }
    }

    /**
     * Submits a vote
     * @param vote1 - first choice vote
     * @param vote2 - second choice vore
     * @param vote3 - third choice vote
     * @throws CandidateNotFoundException is thrown when trying to vote for a candidate whose not nominated and not in the ballots
     * @throws CandidateChosenMoreThanOnceException is thrown when you are trying to vote for the same candidate more than once in your choices
     */
    public void submitVote(String vote1, String vote2, String vote3) throws CandidateNotFoundException, CandidateChosenMoreThanOnceException
    {

        //Checks if any of the candidates aren't on the ballot
        if(!ballot.contains(vote1))
        {
            throw new CandidateNotFoundException(vote1);
        }
        else if(!ballot.contains(vote2))
        {
            throw new CandidateNotFoundException(vote2);
        }
        else if(!ballot.contains(vote3))
        {
            throw new CandidateNotFoundException(vote3);
        }

        //Checks if any of the candidates have been voted for more than once
        if(vote1.equals(vote2))
        {
            throw new CandidateChosenMoreThanOnceException(vote1);
        }
        else if (vote1.equals(vote3))
        {
            throw new CandidateChosenMoreThanOnceException(vote1);
        }
        else if (vote2.equals(vote3))
        {
            throw new CandidateChosenMoreThanOnceException(vote2);
        }

        //Stores the previous amount of votes each candidate has received
        int prevVotes1 = firstVotes.get(vote1);
        int prevVotes2 = secondVotes.get(vote2);
        int prevVotes3 = thirdVotes.get(vote3);

        //Puts the new amount of votes for each candidate into their respective hashmaps
        firstVotes.put(vote1, prevVotes1 + 1);
        secondVotes.put(vote2, prevVotes2 + 1);
        thirdVotes.put(vote3, prevVotes3 + 1);
    }

    /**
     * Finds the winner of voting via the most first choice votes
     */
    public String pickWinnerMostFirstChoice()
    {
        String winner = null; //Stores winning candidate name
        int winnerVotes = 0; //Stores winning candidate amount of votes
        int totalVotes = 0; //Stores the total amount of votes for all candidates

        //Iterate through candidates in firstVotes, sets winner and winnerVotes accordingly
        for(Map.Entry<String, Integer> candidate : firstVotes.entrySet())
        {
            if(candidate.getValue() > winnerVotes)
            {
                winner = candidate.getKey();
                winnerVotes = candidate.getValue();
            }
            totalVotes += candidate.getValue();
        }

        //Returns winner if they got more than 50% of the votes, returns required string if not
        if(totalVotes == 0)
        {
            return null;
        }
        else if((double)winnerVotes / (double)totalVotes > 0.5)
        {
            return winner;
        }
        else
        {
            return "*Requires Runoff Poll*";
        }
    }

    /**
     * Finds the winner of voting via total amount of votes across all choices
     */
    public String pickWinnerMostAgreeable()
    {
        String winner = null; //Stores winning candidate name
        int winnerPoints = 0; //Stores winning candidate amount of votes
        int currentPoints = 0; //Stores current votes of candidate being iterated

        //Iterate through candidates, sets winner and winnerVotes accordingly
        for(String candidate : ballot)
        {
            //chooses the highest votes out of all three choices to give them points for
            if(firstVotes.containsKey(candidate))
            {
                currentPoints = firstVotes.get(candidate);
            }
            if(secondVotes.containsKey(candidate) && secondVotes.get(candidate)>currentPoints)
            {
                currentPoints = secondVotes.get(candidate);
            }
            if(thirdVotes.containsKey(candidate) && thirdVotes.get(candidate)>currentPoints)
            {
                currentPoints = thirdVotes.get(candidate);
            }

            //Updates winner if current candidate has more points than winning candidate
            if(currentPoints > winnerPoints)
            {
                winner = candidate;
                winnerPoints = currentPoints;
            }
        }

        return winner; //Returns current winning candidate (or null if none found)
    }

    /**
     /**
     * Adds a candidate to the ballot if not already on it, throws exception if they are already on it
     * @param newCandidate - new candidate to add to ballot
     * @throws RedundantCandidateException when the candidate being added is already in the ballot
     */
    public void nominateCandidate(String newCandidate) throws RedundantCandidateException
    {
        if(ballot.contains(newCandidate))
        {
            throw new RedundantCandidateException(newCandidate);
        }
        ballot.add(newCandidate);
        firstVotes.put(newCandidate,0);
        secondVotes.put(newCandidate,0);
        thirdVotes.put(newCandidate,0);
    }
}