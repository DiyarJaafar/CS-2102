import java.util.Scanner;

public class PollingDevice
{
    private VotingData vd;
    Scanner keyboard = new Scanner(System.in); //Scanner to read votes from keyboard input

    public PollingDevice(VotingData vd)
    {
        this.vd = vd;
    }

    public void screen() {
        //Collects votes using keyboard
        vd.printBallot();
        System.out.println("Who is your first choice?");
        String candidate1 = keyboard.next();
        System.out.println("Who is your second choice?");
        String candidate2 = keyboard.next();
        System.out.println("Who is your third choice?");
        String candidate3 = keyboard.next();

        try
        {
            vd.submitVote(candidate1, candidate2, candidate3); //Submits counted votes
        }
        catch(CandidateNotFoundException e)
        {
            System.out.println("Would you like to add " + e.getName() + " to the ballot? Y/N");
            String answer = keyboard.next();

            if(answer.equals("Y") || answer.equals("y"))
            {
                addWriteIn(e.getName());
                screen();
                return;
            }
            if (answer.equals("N") || answer.equals("n")){
                screen();
            }
        }
        catch(CandidateChosenMoreThanOnceException e)
        {
            System.out.println("You cannot vote for " + e.getName() + " twice.");
            screen();
            return;
        }

        System.out.println("You voted for: 1-" + candidate1 + " 2-" + candidate2 + " 3-" + candidate3); //Displays upon successful completion of voting
    }

    public void addWriteIn(String newCandidate)
    {
        try
        {
            vd.nominateCandidate(newCandidate);
        }
        catch(RedundantCandidateException e)
        {
            System.out.println("Candidate " + e.getName() + " is already on the ballot.");
        }
    }

}