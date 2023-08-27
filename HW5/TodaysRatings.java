import java.util.LinkedList;
import java.util.GregorianCalendar;

public class TodaysRatings {
    private GregorianCalendar date; //Date of ratings
    private LinkedList<Integer> rankings; //Rankings from all surveys
    private LinkedList<Integer> downloads; //Downloads from all surveys

    /**
     * TodaysRatings constructor
     * @param date - date of ratings
     * @param rankings - rankings from all surveys
     * @param downloads - downloads from all surveys
     */
    public TodaysRatings(GregorianCalendar date, LinkedList<Integer> rankings, LinkedList<Integer> downloads)
    {
        this.date = date;
        this.rankings = rankings;
        this.downloads = downloads;
    }

    /**
     * foes through the list of today ratings to return the best rank
     * @return best rank (1 being top)
     */
    public int bestRankToday(){
        if (rankings.isEmpty()){ //makes sure the list is not empty otherwise return -1 for excemption
            return -1;
        }
        int bestRank = rankings.get(0); //starts with the first element stored in a local variable tracker
        for (int rank:rankings){ //goes through the list of rankings
            if (rank<bestRank){ //it updates the tracker if the compared rank is lower
                bestRank=rank;
            }
        }
        return bestRank; //returns the stored rank of the day
    }

    /**
     * calcualtes the total downloads for the day
     * @return an integer for the total downloads in the day
     */
    public int downloadsToday (){
        int total = 0; //running total
        for (int dwn : downloads){ //goes through todays list of downlaods
            total = total +dwn; // adds it to the running total
        }
        return total; //returns the total
    }

    /**
     * checks whether the input date is correct or not
     * @param month integer representing the month (jan =0, feb=1.....)
     * @param year integer representing the year (2014)
     * @return returns true if the object date matches the parameter input of month and year
     */
    public boolean isToday (int month, int year){
        if (month == date.get(GregorianCalendar.MONTH) && year==date.get(GregorianCalendar.YEAR)){ //checks if the date of the current object is the same as the parameter
            return true;
        }
        return false;
    }
}