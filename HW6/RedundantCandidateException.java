public class RedundantCandidateException extends Exception
{
    private String name;
    /**
     * CandidateNotFoundException constructor
     * @param candidateName - name of the candidate which triggered the exception
     */
    public RedundantCandidateException(String candidateName)
    {
        super("RedundantCandidateException: Candidate \"" + candidateName + "\" is already on the ballot");
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