public class CandidateChosenMoreThanOnceException extends Exception {
    private String name;
    /**
     * CandidateChosenMoreThanOnceException constructor
     * @param candidateName - name of the candidate which triggered the exception
     */
    public CandidateChosenMoreThanOnceException(String candidateName)
    {
        super("CandidateChosenMoreThanOnceException: Candidate \"" + candidateName + "\" cannot be voted for more than once");
        this.name = candidateName;
    }
    /**
     * Returns name of candidate that threw exception
     */
    public String getName()
    {
        return name;
    }
}