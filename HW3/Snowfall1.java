import java.util.LinkedList;

class Snowfall1 {
  Snowfall1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum >= 101; } // Jan 1st
  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) { return ((int)( dateNum / 100)); }

  /**
   * cleans the list of data from other months and invalid data
   * @param dataList data list
   * @param month the month we want the data from
   * @return clean list of data from the specified month
   */
  public LinkedList<Double> returnOnlySpecifiedMonthCleaned (LinkedList<Double> dataList, int month){
    LinkedList<Double> cleanedList = new LinkedList<>(); //creates a list
    int startOfMonthIndex = 0; //identify the start of month index location in the list
    int endOfMonth = (month*100)+33; //tells us the max date value within a month
    for (int i = 0; i<dataList.size(); i++){ //loops over the data looking for the first appearance of the month date
      if(dataList.get(i)>month*100){ //stores the index location of the date if it is the month we are looking for
        startOfMonthIndex = i;
        break;
      }
    }
    for (int i = startOfMonthIndex; i<dataList.size(); i++){ //adds the data from and after the start of the first date of the month
      if (dataList.get(i)>endOfMonth){ //breaks out of the loop if the month end
        break;
      }
        if(dataList.get(i)<0){ //cleans the data by adding a zero if its negative
          cleanedList.add(0.0);
        }
        else { //adds the data to the clean list
          cleanedList.add(dataList.get(i));
        }

    }
    return cleanedList;
  }

  /**
   * creates a report of MaxInch list within a month where each data stores the date and its max snowfall
   * @param data list of readings of snowfall and dates
   * @param month the month which the data is needed
   * @return a list of Maxinch within the month
   */
  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxInchReport> report = new LinkedList<>(); //creates the list for the report
    LinkedList<Double> cleanList = returnOnlySpecifiedMonthCleaned(data,month); //stores the clean list
    double currentDate = 0; // keeps track of the date
    double snowData = 0.0; // keeps track of the snowfall largest data
    for (Double aData : cleanList){ // loops through the list
      if (aData>99){ // identifies the dates
        if (currentDate!=0){ //creates and adds a MaxInch object to the list
          report.add(new MaxInchReport(currentDate,snowData));
        }
        currentDate = aData; // updates the date with the new one
        snowData = 0.0; //resets the snowfall data
      }
      if(aData<99 && aData>snowData){ // identifies snowfall data that are larger than the current largest data for that day
        snowData = aData; //updates the largest snowfall data if it is in fact larger
      }
    }
    report.add(new MaxInchReport(currentDate,snowData)); //adds the last date MaxInch object since the loop has finished
    return report;
  }
}  

