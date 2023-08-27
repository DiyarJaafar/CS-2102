public class ReadingResult implements IChallenge {

    int avBooksPerDayGoal;
    BooksRead fiction;
    BooksRead nonFiction;

    public ReadingResult (int avBookGoal, BooksRead fiction, BooksRead nonFiction){
        this.fiction=fiction;
        this.nonFiction=nonFiction;
        this.avBooksPerDayGoal=avBookGoal;
    }

    public double averagePerDay() {
        double total = fiction.booksRead + nonFiction.booksRead;
        return total/(double) 31;
    }

    public double differenceFromGoal() {
        double diff = avBooksPerDayGoal-averagePerDay();
        if (diff>=0)
            return diff;
        else
            return 0;

    }
}
