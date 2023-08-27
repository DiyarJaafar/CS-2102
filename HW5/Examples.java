import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class Examples
{
    RadioStation rs;
    GregorianCalendar today;
    RatingsLL ratings;
    LinkedList<Survey> surveys;

    //Testing RadioStation.bestRankThisMonth() method
    @Test
    public void testRadioStationBestRankThisMonth() throws NoRankThisMonthException
    {
        //Create new Survey LinkedList and populate it
        surveys = new LinkedList<Survey>();
        surveys.add(new Survey(10, 90));
        surveys.add(new Survey(11, 80));
        surveys.add(new Survey(12, 70));
        surveys.add(new Survey(13, 60));
        surveys.add(new Survey(14, 50));

        today = new GregorianCalendar(2003, 4, 1); //Instantiate today as April 1, 2003

        ratings = new RatingsLL(); //Instantiate RatingsLL object

        //Create new radio station and populate it with surveys
        rs = new RadioStation(ratings, today);
        rs.addTodaysSurveys(surveys);

        assertTrue(rs.bestRankThisMonth() == 10); //Test that best rank obtained
    }

    //Testing RadioStation.totalSongDownloads() method
    @Test
    public void testRadioStationTotalDownloads()
    {
        //Create new Survey LinkedList and populate it
        surveys = new LinkedList<Survey>();
        surveys.add(new Survey(10, 90));
        surveys.add(new Survey(11, 80));
        surveys.add(new Survey(12, 70));
        surveys.add(new Survey(13, 60));
        surveys.add(new Survey(14, 50));

        today = new GregorianCalendar(2003, GregorianCalendar.APRIL, 1); //Instantiate today as April 1, 2003

        ratings = new RatingsLL(); //Instantiate RatingsLL object

        //Create new radio station and populate it with surveys
        rs = new RadioStation(ratings, today);
        rs.addTodaysSurveys(surveys);

        assertTrue(rs.totalSongDownloads(GregorianCalendar.APRIL, 2003) == 350); //Test that best rank obtained
    }

    //Testing RadioStation.bestRankThisMonth() method with a switch in months
    @Test
    public void testRadioStationBestRankThisMonthSwitch() throws NoRankThisMonthException
    {
        //Create new Survey LinkedList and populate it
        surveys = new LinkedList<Survey>();
        surveys.add(new Survey(10, 90));
        surveys.add(new Survey(11, 80));
        surveys.add(new Survey(12, 70));
        surveys.add(new Survey(13, 60));
        surveys.add(new Survey(14, 50));

        today = new GregorianCalendar(2003, GregorianCalendar.JANUARY, 31); //Instantiate today as January 31, 2003

        ratings = new RatingsLL(); //Instantiate RatingsLL object

        //Create new radio station and populate it with surveys
        rs = new RadioStation(ratings, today);
        rs.addTodaysSurveys(surveys); //!THE DATE SHOULD NOW SWITCH TO FEBRUARY 1, 2003

        //Clear Survey LinkedList and repopulate it with new data
        surveys.clear();
        surveys.add(new Survey(15, 40));
        surveys.add(new Survey(16, 30));
        surveys.add(new Survey(17, 20));
        surveys.add(new Survey(18, 10));
        surveys.add(new Survey(19, 0));

        rs.addTodaysSurveys(surveys); //Add new surveys in different month to RadioStation

        assertTrue(rs.bestRankThisMonth() == 15);
    }

    //Testing RadioStation.totalSongDownloads() method with a switch in months
    @Test
    public void testRadioStationTotalDownloadsSwitch() throws NoRankThisMonthException
    {
        //Create new Survey LinkedList and populate it
        surveys = new LinkedList<Survey>();
        surveys.add(new Survey(10, 90));
        surveys.add(new Survey(11, 80));
        surveys.add(new Survey(12, 70));
        surveys.add(new Survey(13, 60));
        surveys.add(new Survey(14, 50));

        today = new GregorianCalendar(2003, GregorianCalendar.JANUARY, 31); //Instantiate today as January 31, 2003

        ratings = new RatingsLL(); //Instantiate RatingsLL object

        //Create new radio station and populate it with surveys
        rs = new RadioStation(ratings, today);
        rs.addTodaysSurveys(surveys); //!THE DATE SHOULD NOW SWITCH TO FEBRUARY 1, 2003

        //Clear Survey LinkedList and repopulate it with new data
        surveys.clear();
        surveys.add(new Survey(15, 40));
        surveys.add(new Survey(16, 30));
        surveys.add(new Survey(17, 20));
        surveys.add(new Survey(18, 10));
        surveys.add(new Survey(19, 0));

        rs.addTodaysSurveys(surveys); //Add new surveys in different month to RadioStation

        assertTrue(rs.totalSongDownloads(GregorianCalendar.FEBRUARY, 2003) == 100);
    }

    //Testing RadioStation.bestRankThisMonth with no rank this month
    @Test
    public void testRadioStationBestRankThisMonthEmpty() throws NoRankThisMonthException
    {
        surveys = new LinkedList<Survey>(); //Create empty Survey LinkedList
        today = new GregorianCalendar(2003, 4, 1); //Instantiate today as April 1, 2003
        ratings = new RatingsLL(); //Instantiate RatingsLL object

        //Create new radio station and populate it with surveys
        rs = new RadioStation(ratings, today);
        rs.addTodaysSurveys(surveys);

        assertThrows(NoRankThisMonthException.class, () -> {rs.bestRankThisMonth();});
    }
}