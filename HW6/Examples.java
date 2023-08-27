import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {

    VotingData setup1() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("ahmed");
            vd.nominateCandidate("dan");
            vd.nominateCandidate("gompie");

        } catch (Exception e) {}
        return(vd);
    }

    @Test
    public void testPickWinnerFirstChoiceObvious(){
        VotingData vd = this.setup1();
        try {
            vd.submitVote("ahmed", "dan", "gompie");
            vd.submitVote("ahmed", "gompie", "dan");
            vd.submitVote("ahmed", "gompie", "dan");
        } catch (Exception e) {}
        assertEquals("ahmed",vd.pickWinnerMostFirstChoice());
    }
    @Test
    public void testPickWinnerFirstChoiceRunOff(){
        VotingData vd = this.setup1();
        try {
            vd.submitVote("dan", "gompie", "ahmed");
            vd.submitVote("dan", "gompie", "ahmed");
            vd.submitVote("ahmed", "gompie", "dan");
            vd.submitVote("ahmed", "gompie", "dan");
        } catch (Exception e) {}
        assertEquals("*Requires Runoff Poll*",vd.pickWinnerMostFirstChoice());
    }
    @Test
    public void mostAgreeableWinnerTest(){
        VotingData vd = this.setup1();
        try {
            vd.submitVote("dan", "gompie", "ahmed");
            vd.submitVote("dan", "gompie", "ahmed");
            vd.submitVote("ahmed", "gompie", "dan");
            vd.submitVote("ahmed", "gompie", "dan");
        } catch (Exception e) {}
        assertEquals("gompie",vd.pickWinnerMostAgreeable());
    }
    @Test(expected=CandidateChosenMoreThanOnceException.class)
    public void testCandChosenTwiceExcep() throws CandidateChosenMoreThanOnceException {
        VotingData vd = this.setup1();
        try {
            vd.submitVote("dan", "dan", "ahmed");
        } catch (CandidateNotFoundException e) {}
    }
    @Test(expected=CandidateNotFoundException.class)
    public void testVotingForWrongCandExcep() throws CandidateNotFoundException {
        VotingData vd = this.setup1();
        try {
            vd.submitVote("Diyar", "dan", "ahmed");
        } catch (CandidateChosenMoreThanOnceException e) {}
    }
    @Test(expected=RedundantCandidateException.class)
    public void nomAlreadyNominatedCandidate() throws RedundantCandidateException {
        VotingData vd = this.setup1();
        try {
            vd.submitVote("gompie", "dan", "ahmed");
        } catch (Exception e) {}
        vd.nominateCandidate("gompie");
    }
}