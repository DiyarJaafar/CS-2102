public class CandidateNotFoundException extends Exception {
    private String name;
    /**
     * CandidateNotFoundException constructor
     * @param candidateName - name of the candidate which triggered the exception
     */
    public CandidateNotFoundException(String candidateName)
    {
        super("CandidateNotFoundException: Candidate \"" + candidateName + "\" not found");
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