import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class SnowfallExamples {
  Snowfall1 E1 = new Snowfall1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxInchReport> DecReports = new LinkedList<MaxInchReport>();
  LinkedList<Double> test2 = new LinkedList<Double>();
  LinkedList<MaxInchReport> test2Comparison = new LinkedList<MaxInchReport>();
  
  public SnowfallExamples() {
    threeDates.add(1113.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(1120.0);
    threeDates.add(4.0);
    threeDates.add(5.0);
    threeDates.add(4.5);
    threeDates.add(1201.0);
    threeDates.add(6.0);
    threeDates.add(-0.5);
    DecReports.add(new MaxInchReport(1201.0,6.0));
    test2.add(101.0);
    test2.add(-1.0);
    test2.add(-5.0);
    test2.add(531.0);
    test2.add(10.0);
    test2.add(10.5);
    test2.add(10.6);
    test2.add(1001.0);
    test2.add(-6.0);
    test2.add(0.5);
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(DecReports,
                 E1.dailyMaxForMonth(threeDates, 12));
  }
  @Test
  public void OurTest() {
    test2Comparison.add(new MaxInchReport(101.0,0.0));
    assertEquals(test2Comparison, E1.dailyMaxForMonth(test2, 1));
  }
  @Test
  public void OurTest1() {
    test2Comparison.add(new MaxInchReport(531.0,10.6));
    assertEquals(test2Comparison, E1.dailyMaxForMonth(test2, 5));
  }
  @Test
  public void OurTest2() {
    test2Comparison.add(new MaxInchReport(1001.0,0.5));
    assertEquals(test2Comparison, E1.dailyMaxForMonth(test2, 10));
  }
}
//Subtasks
//        identify the month given
//        extract that month data from the dataList
//        clean it by turning negatives into zero
//        add them to a new cleanList
//        create a new list for reports
//        loop through the clean list of data
//        keep track of the date and snow fall data
//        update the snow fall variable if the next data is larger
//        if the current data is a date create a MaxInchReport using the stored data and add it to the report list
//        update the date and reset the snowfall variable
