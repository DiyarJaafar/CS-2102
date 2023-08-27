import java.util.LinkedList;

class Snowfall2 {
  Snowfall2(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum >= 101; } // Jan 1st
  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) { return ((int)( dateNum / 100)); }

  /**
   * Returns list containing the maximum amount of snowfall every day for a month
   */
  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    double currentDate = 0; //Stores day information during iteration
    double currentMax = -1; //Stores current maximum (-1 means no data)
    LinkedList<MaxInchReport> returnedData = new LinkedList<MaxInchReport>();

    for(Double i : data) //Iterates through every element in data
    {
      if(i < 100) //If the current element is a measurement below 100
      {
        if(i > currentMax && i > 0) //Set new current max if measured data is above the current maximum
        {
          currentMax = i;
        }
        else if(currentMax == -1 && i < 0) //Sets new max to 0 if there is no data in currentMax and the current data is negative
        {
          currentMax = 0;
        }
      }
      else if (i >= 100) //If the current element is a date
      {
        if((double)month*100 + 31 - currentDate < 100 && (double)month*100 + 31 - currentDate > -100) //Check if the current date is in month
        {
          if(currentDate != 0 && currentMax != -1) //Add data to LinkedList if the data is in the proper month and there is data being tracked
          {
            returnedData.add(new MaxInchReport(currentDate, currentMax)); //Add new MaxInchReport object to returned data
          }
        }
        currentDate = i; //Set current date to new date
        currentMax = -1; //Set current max to -1 (no data)
      }
    }
    if((double)month*100 + 31 - currentDate < 100 && (double)month*100 + 31 - currentDate > -100) //Check if the current date is in month
    {
      if(currentDate != 0 && currentMax != -1) //Add last element to returned list if possible
      {
        returnedData.add(new MaxInchReport(currentDate, currentMax)); //Add new MaxInchReport object to returned data
      }
    }

    return returnedData; //Returns data
  }
}