public class WritingResult implements IChallenge{

    double numOfWords;
    int dayOfNovUpdate;

    public WritingResult (double numOfWords, int dayOfNovUpdate){
        this.numOfWords = numOfWords;
        this.dayOfNovUpdate=dayOfNovUpdate;
    }

    public double averagePerDay() {
       return numOfWords/(double) dayOfNovUpdate;
    }

    public double differenceFromGoal() {
        return 50000-numOfWords/(double) 31-dayOfNovUpdate;
        }
}
