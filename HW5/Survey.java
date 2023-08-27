public class Survey {
     int rank; //Rank of the band
     int downloads; //Band's downloads since last survey

     /**
      * Survey constructor
      * @param rank - The rank of the band in the survey
      * @param downloads - The amount of downloads since last survey
      */
     public Survey(int rank, int downloads)
     {
          this.rank = rank;
          this.downloads = downloads;
     }
}