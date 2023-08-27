import java.util.GregorianCalendar;
import java.util.LinkedList;

public class RatingsLL implements IRatings{
    private LinkedList<TodaysRatings> ratings = new LinkedList<>();
    /**
     * RatingsLL Constructor
     */
    public RatingsLL(){}

    /**
     * Adds a TodaysRating object to the rating list of the station
     * @param surveyList list of surveys done in the day to be added to the list of TodayRatings
     */
    public void addToList(LinkedList<Survey> surveyList, GregorianCalendar today) {
        LinkedList<Integer> rank = new LinkedList<Integer>(); //Keeps track of today's rankings
        LinkedList<Integer> downloads = new LinkedList<Integer>(); //Keeps track of today's downloads

        for(Survey survey : surveyList)
        {
            rank.add(survey.rank); //Adds today's surveyed ranks to LinkedList
            downloads.add(survey.downloads); //Adds today's surveyed downloads to LinkedList
        }

        ratings.add(new TodaysRatings(today, rank, downloads)); //Adds new ratings to ratings
    }
    /**
     * Gets the total amount of song downloads given a certain month and year
     * @param month - month to calculate song downloads in
     * @param year - year to calculate song downloads in
     */
    public int totalDownloads(int month, int year) {
        int monthTotalDownloads = 0; //keeps track of the total
        for (TodaysRatings aRating : this.ratings){ //goes through the list
            if (aRating.isToday(month,year)){ //checks if the date of the object matches the parameter
                monthTotalDownloads=monthTotalDownloads+aRating.downloadsToday(); //adds the total downloads in that day to the stacking total
            }
        }
        return monthTotalDownloads; //returns the total
    }

    /**
     * Gets the best rank this month
     * @param month the month represented by integer (0 for Jan, 1 for Feb....etc)
     * @param year the year in integer (2014)
     * @return the highest ranking in the month represented in an integer
     */
    public int MonthsBestRank(int month, int year){
        int bestRankThisMonth = -1; //Keep track of best rank this month
        for(TodaysRatings rating : ratings) { //goes through the list
            if((rating.bestRankToday()!=-1) && (rating.isToday(month,year))) { //makes sure the object is not empty and its date matches the parameter daye
                if (rating.bestRankToday()<bestRankThisMonth || bestRankThisMonth==-1){//checks if its the first rank to be updated if not then makes sure its higher rank
                    bestRankThisMonth=rating.bestRankToday(); // updates the ranking tracker
                }
            }
        }

        return bestRankThisMonth; //Return best rank this month
    }

}
