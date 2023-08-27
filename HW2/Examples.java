// Eri Kim and Aruzhan Koshkarova
// ekim4 and akoshkarova

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;


public class Examples {
    /* HW1
    RugbyTeam rugbyTeamNewZealand = new RugbyTeam("Clark", "blue", true, 7, 1);
    RoboticsTeam robotsTeamWPI = new RoboticsTeam("WPI","goat cheese", 7);
    RoboticsTeam robotsTeamClark = new RoboticsTeam("Clark","dog boan", 5);
    RoboticsTeam robotsTeamMIT = new RoboticsTeam ("MIT", "strong arm", 9);
    RugbyResult rugbyResultCheck = new RugbyResult(rugbyTeamNewZealand, rugbyTeamUS, 10.5,15.2);
    RugbyResult rugbyResultCheck2 = new RugbyResult (rugbyTeamNewZealand, rugbyTeamUS, 210.5, 150.2);
    RugbyResult rugbyResultCheckEdgeCase = new RugbyResult (rugbyTeamNewZealand, rugbyTeamUS, 150, 150);
    RoboticsResult robotsResultCheck = new RoboticsResult(robotsTeamWPI, robotsTeamWPI, 3.1, 5.1, true, 3.2, 2, false);
    RoboticsResult robotsResultCheck2 = new RoboticsResult (robotsTeamClark, robotsTeamMIT, 17, 17, true, 17, 17, true);
    RoboticsResult robotsResultCheckEdgeCase = new RoboticsResult (robotsTeamWPI, robotsTeamMIT, 16, 8, true, 16, 8, true);
    Match rugbyMatchCheck = new Match(rugbyTeamUS, rugbyTeamNewZealand, rugbyResultCheck);
    Match rugbyMatchCheck2 = new Match(rugbyTeamUS, rugbyTeamNewZealand, rugbyResultCheck2);
    Match robotsMatchCheck = new Match(robotsTeamWPI, robotsTeamWPI, robotsResultCheck);
    RoboticsResult robotsResultCheckNull = new RoboticsResult (robotsTeamWPI, robotsTeamClark, 23.1, 5.1, true, 3.2, 2, false);
    Match robotsMatchCheckNull = new Match (robotsTeamWPI, robotsTeamClark, robotsResultCheckNull);
    */
	
	RugbyTeam rugbyTeamCanada = new RugbyTeam("Canada", "red", false, 4, 6);

    RugbyTeam rugbyTeamPortugal = new RugbyTeam("Portugal", "blue", true, 7, 1);

    RugbyTeam rugbyTeamKazakhstan = new RugbyTeam("Kazakhstan", "light blue", true, 13, 2);

    RoboticsTeam robotsTeamMIT = new RoboticsTeam("MIT", "beever", 7);

    RoboticsTeam robotsTeamUT = new RoboticsTeam("UT", "dog boan", 5);

    RugbyResult rugbyResultCheck1 = new RugbyResult( rugbyTeamCanada, rugbyTeamPortugal,7.5, 15.2);
    RugbyResult rugbyResultCheck2 = new RugbyResult(rugbyTeamCanada, rugbyTeamKazakhstan, 8.5, 13.2);
    RugbyResult rugbyResultCheck3 = new RugbyResult(rugbyTeamKazakhstan, rugbyTeamPortugal, 9, 10);
    RugbyResult rugbyResultCheck4 = new RugbyResult(rugbyTeamPortugal, rugbyTeamPortugal, 10, 10);


    RoboticsResult robotsResultCheck = new RoboticsResult(robotsTeamMIT, robotsTeamUT, 3.1, 5.1, true, 3.2, 2, false);

    Match rugbyMatch1Check = new Match(rugbyTeamCanada, rugbyTeamPortugal, rugbyResultCheck1);
    Match rugbyMatch2Check = new Match(rugbyTeamCanada, rugbyTeamKazakhstan, rugbyResultCheck2);
    Match rugbyMatch3Check = new Match(rugbyTeamKazakhstan, rugbyTeamPortugal, rugbyResultCheck3);
    Match rugbyMatch4Check = new Match(rugbyTeamKazakhstan, rugbyTeamPortugal, rugbyResultCheck1);


    Match robotsMatchCheck = new Match(robotsTeamMIT, robotsTeamUT, robotsResultCheck);
    RoboticsResult robotsResultCheckNull = new RoboticsResult(robotsTeamMIT, robotsTeamUT, 23.1, 5.1, true, 3.2, 2, false);
    Match robotsMatchCheckNull = new Match(robotsTeamMIT, robotsTeamUT, robotsResultCheckNull);
    
    InitRound initRound = new InitRound(new LinkedList<Match>());
    AdvancedRound advancedRound= new AdvancedRound(new LinkedList<Match>(), new LinkedList<IContestant>());
    Tournament tnmt = new Tournament(new LinkedList<IWinner>());
    LinkedList<Match> rugbyMatch1CheckLinkedList= new LinkedList<Match>();
    LinkedList<Match> rugbyMatch2CheckLinkedList= new LinkedList<Match>();
    LinkedList<Match> rugbyMatch3CheckLinkedList= new LinkedList<Match>();

    LinkedList<IContestant> rugbyMatch1ContestantLinkedList= new LinkedList<IContestant>();
    LinkedList<IContestant> rugbyMatch2ContestantLinkedList= new LinkedList<IContestant>();
    LinkedList<IContestant> rugbyMatch3ContestantLinkedList= new LinkedList<IContestant>();
    LinkedList<Match> robotsMatchCheckLinkedList = new LinkedList<Match>();
    LinkedList<IContestant> emptyListFor2teams= new LinkedList<IContestant>();
    LinkedList<IContestant> answerForFirstRound = new LinkedList<IContestant>();
    LinkedList<Match> LinkedListForFirstRound= new LinkedList<Match>();

    AdvancedRound semiFinalsRound ;
    AdvancedRound emptyRound;
    AdvancedRound finalsRound;
    InitRound firstRound;
    
    public Examples(){
        rugbyMatch1CheckLinkedList.add(rugbyMatch1Check);
        rugbyMatch1CheckLinkedList.add(rugbyMatch1Check);

        rugbyMatch1ContestantLinkedList.add(rugbyTeamCanada);
        rugbyMatch1ContestantLinkedList.add(rugbyTeamPortugal);
        semiFinalsRound= new AdvancedRound(rugbyMatch1CheckLinkedList, rugbyMatch1ContestantLinkedList);
        robotsMatchCheckLinkedList.add(robotsMatchCheck);
        emptyListFor2teams.add(null);
        emptyListFor2teams.add(null);
        emptyRound = new AdvancedRound(rugbyMatch3CheckLinkedList, rugbyMatch3ContestantLinkedList);

        LinkedListForFirstRound.add(robotsMatchCheck);
        firstRound=new InitRound(LinkedListForFirstRound);
        answerForFirstRound.add(robotsTeamUT);

        //Match rugbyMatch2Check = new Match(rugbyTeamCanada, rugbyTeamKazakhstan, rugbyResultCheck2);
        //Match rugbyMatch3Check = new Match(rugbyTeamKazakhstan, rugbyTeamPortugal, rugbyResultCheck3);
        //RugbyResult rugbyResultCheck2 = new RugbyResult(rugbyTeamCanada, rugbyTeamKazakhstan, 8.5, 13.2); -> Kazakhstan
        //RugbyResult rugbyResultCheck3 = new RugbyResult(rugbyTeamKazakhstan, rugbyTeamPortugal, 9, 10); ->Portugal
        rugbyMatch2CheckLinkedList.add(rugbyMatch2Check);
        rugbyMatch2CheckLinkedList.add(rugbyMatch3Check);

        rugbyMatch2ContestantLinkedList.add(rugbyTeamCanada);
        rugbyMatch2ContestantLinkedList.add(rugbyTeamKazakhstan);
        rugbyMatch2ContestantLinkedList.add(rugbyTeamPortugal);
        finalsRound = new AdvancedRound(rugbyMatch2CheckLinkedList, rugbyMatch2ContestantLinkedList);

        rugbyMatch3CheckLinkedList.add(rugbyMatch4Check);
        rugbyMatch3CheckLinkedList.add(rugbyMatch4Check);
        rugbyMatch3ContestantLinkedList.add(rugbyTeamCanada);
        rugbyMatch3ContestantLinkedList.add(rugbyTeamCanada);
        
        tnmt.add(finalsRound);
        tnmt.add(advancedRound);
        

    }
    
    @Test

    //checking test getMatchWinners() method on empty list in InitRound
    public void test() {
        assertEquals (finalsRound.contestants.size(), 3);
    }

    @Test

    //checking test getMatchWinners() method on empty list in InitRound
    public void testGetMatchWinnersEmptyListInitRound() {
        assertEquals (initRound.getMatchWinners().size(), 0);
    }



    @Test

    //checking test getMatchWinners() method on empty list in InitRound
    public void testGetMatchWinnerInitRound() {
        assertEquals (firstRound.getMatchWinners(), answerForFirstRound);
    }


    @Test

    //checking test getMatchWinners() method on empty list in AdvancedRound
    public void testGetMatchWinnersEmptyListAdvRound() {
        assertEquals (advancedRound.getMatchWinners().size(), 0);
    }


    @Test

    //checking test getMatchWinners() method on non empty list in AdvancedRound
    public void testGetMatchWinnersAdvRound() {
        assertEquals (emptyRound.getMatchWinners(), rugbyMatch3ContestantLinkedList);
    }

    @Test

    //checking test getNumWinners() method on non empty list in AdvancedRound
    public void testGetNumWinnersAdvRound() {
        assertEquals (semiFinalsRound.getNumWinners(), 4);
    }

    @Test

    //checking test getNumWinners() method on empty list in AdvancedRound
    public void testGetNumWinnersEmptyListAdvRound() {
        assertEquals (advancedRound.getNumWinners(), 0);
    }

    @Test

    //checking test getNumWinners() method on empty list in InitRound
    public void testGetNumWinnersEmptyListInitRound() {
        assertEquals (initRound.getNumWinners(), 0);
    }


    @Test

    //checking test getNumWinners() method on non empty list in InitRound
    public void testGetNumWinnersInitRound() {
        assertEquals (firstRound.getNumWinners(), 1);
    }

    @Test

    //checking test isWinner() method on non empty list in InitRound and outputs True
    public void testIsWinnerInitRoundTrue() {
        assertTrue (firstRound.isWinner(robotsTeamUT));
    }

    @Test

    //checking test isWinner() method on non empty list in InitRound and outputs False
    public void testIsWinnerInitRoundFalse() {
        assertFalse (firstRound.isWinner(robotsTeamMIT));
    }

    @Test

    //checking test isWinner() method on non empty list in InitRound and outputs False
    public void testIsWinnerAdvRoundFalse() {
        assertFalse (semiFinalsRound.isWinner(robotsTeamUT));
    }

    @Test

    //checking test isWinner() method on non empty list in AdvancedRound and outputs True
    public void testIsWinnerAdvRoundTrue() {
        assertTrue (finalsRound.isWinner(rugbyTeamCanada));
    }

    @Test

    //checking test isWinner() method on non empty list in InitRound and outputs False
    public void testFinalWinnerIsValidAdvRoundFalse() {
        assertFalse(tnmt.finalWinnerIsValid(null));
    }
    

    /* HW1
    @Test
    // checking isValid() method with rugby teams
    // output is true since the rugbyResultCheck is valid
    public void testIsValidRugbyTrue(){
        assertTrue(rugbyResultCheck.isValid());
    }
    
    @Test
    // checking isValid() method when result is bigger than 150
    // output is false since the points should not exceed 150 in order to be valid
    public void testIsValidRugbyFalse(){
        assertFalse(rugbyResultCheck2.isValid());
    }
    
    @Test
    // checking isValid() method when result is bigger than 150
    // output is false since the points should not exceed 150 in order to be valid
    public void testIsValidRugbyFalseEdgeCase(){
        assertFalse(rugbyResultCheckEdgeCase.isValid());
    }

    @Test
    // checking isValid() method with robotics teams
    // output is true since the robotsResultCheck is valid
    public void testIsValidRobotsTrue(){
        assertTrue(robotsResultCheck.isValid());
    }
    
    @Test
    // checking isValid() method with robotics teams 
    // output is false due to the large number of team tasks and points
    public void testIsValidRobotsFalse(){
        assertFalse(robotsResultCheck2.isValid());
    }
    
    @Test
    // checking isValid() method with robotics teams
    // output is false
    public void testIsValidRobotsFalseEdgeCase(){
        assertFalse(robotsResultCheckEdgeCase.isValid());
    }

    @Test
    // checking getScore() method with robotics teams
    // when teamFell == false
    public void testGetScoreRobots(){
        assertEquals(robotsResultCheck.getScore(3.2, 1, false), 4.2, 0.1);
    }
    
    @Test
    // checking getScore() method with robotics teams
    // when teamFell == true
    public void testGetScoreRobots2(){
        assertEquals(robotsResultCheck.getScore(6.2, 1, true), 2.2, 0.1);
    }

    @Test
    // checking winner() method with rugby teams
    public void testWinnerRugby(){
        assertEquals(rugbyTeamUS, rugbyMatchCheck.winner());
    }

    @Test
    // checking winner() method with robotics teams
    public void testWinnerRobotics(){
        assertEquals(robotsTeamWPI,robotsMatchCheck.winner());
    }
    
    @Test
    // checking method winner() on robotics teams and returns null
    public void testWinnerRoboticsNull(){
        assertEquals(robotsMatchCheckNull.winner(), null);
    }

    @Test
    // checking expectToBeat() method with rugby teams 
    // output is false
    public void rugbyTeamUSExpectToBeatRugbyNewZealand(){
        assertFalse(rugbyTeamUS.expectToBeat(rugbyTeamNewZealand));
    }

    @Test
    // checking expectToBeat() with rugby teams 
    // output is true
    public void rugbyNewZealandExpectToBeatRugbyTeamUS(){
        assertTrue(rugbyTeamNewZealand.expectToBeat(rugbyTeamUS));
    }

    @Test
    //checking expectToBeat() with robotics teams
    // output is true
    public void robotsTeamWPIExpectToBeatRobotsTeamClark(){
        assertTrue(robotsTeamWPI.expectToBeat(robotsTeamClark));
    }

    @Test
    //checking expectToBeat() with robotics teams  
    // output is false
    public void robotsTeamClarkExpectToBeatRobotsTeamWPI(){
        assertFalse(robotsTeamClark.expectToBeat(robotsTeamWPI));
    }
    */
    

}


