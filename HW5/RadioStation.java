import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class RadioStation {
    private IRatings ratings;
    private GregorianCalendar today;

    /**
     * RadioStation constructor
     * @param ratings - ratings of the day
     * @param today - today's date
     */
    public RadioStation(IRatings ratings, GregorianCalendar today)
    {
        this.ratings = ratings;
        this.today = today;
    }

    /**
     * Gets the best rank this month
     */
    public int bestRankThisMonth() throws NoRankThisMonthException {
        int result = ratings.MonthsBestRank(today.get(GregorianCalendar.MONTH),today.get(GregorianCalendar.YEAR)); //calls the best rank funcionof the interface and stores it in a variable
        if(result == -1){ //Throw exception if there is no rank for this month{
            throw new NoRankThisMonthException("RadioStation.bestRankThisMonth() Exception: NoRankThisMonthException");
        }
        return result; //returns the rank
    }

    /**
     * Gets the total amount of song downloads given a certain month and year
     * @param month - month to calculate song downloads in
     * @param year - year to calculate song downloads in
     */
    public int totalSongDownloads(int month, int year) {
        return ratings.totalDownloads(month,year); //runs the total counter function of the interface
    }

    /**
     * Adds a TodaysRating object to the rating list of the station
     * @param surveys list of surveys done in the day to be added to the list of TodayRatings
     */

    public void addTodaysSurveys(LinkedList<Survey> surveys) {
        ratings.addToList(surveys, new GregorianCalendar(today.get(GregorianCalendar.YEAR), today.get(GregorianCalendar.MONTH), today.get(GregorianCalendar.DAY_OF_MONTH))); //adds the surveys to the data structure (with new GregorianCalendar object to prevent accidental mutation)
        today.add(GregorianCalendar.DAY_OF_MONTH, 1); //Adds 1 day to the current date
    }

    /*
    1) I think an AVL would be ideal for this case, this is because LL has a O(n) search time
    while for the AVL it would have a run time O(log(n)) instead
    2) it would have a completely different implementation since AVL ST use recursion to go through the data
    while LL use for each loop is an example, but it would still have the same methods and method signitures
    just diffrrent implementation like add where AVL would construct a new subtree with multiple object instead of one in LL
    3) I think it is completely possible to add an AVL without changing the interface but we might needs to
    create a few more helper methods to implement some of the methods that were easier to do with the built in methods
    of LL that is not available in AVL
     */
}