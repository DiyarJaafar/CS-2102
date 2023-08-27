import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IRatings {
    //Adds a TodaysRating object to the rating list of the station
void addToList (LinkedList<Survey> surveyList, GregorianCalendar today);
//Gets the total amount of song downloads given a certain month and year
int totalDownloads (int month , int year);
//Gets the best rank this month
int MonthsBestRank (int month, int year);

}
