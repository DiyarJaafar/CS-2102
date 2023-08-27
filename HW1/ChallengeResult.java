public class ChallengeResult {

    ReadingResult readingResult;
    WritingResult writingResult;

    public ChallengeResult (ReadingResult rR, WritingResult wR){
        this.readingResult=rR;
        this.writingResult=wR;
    }

    public double howClose(){
       return this.readingResult.differenceFromGoal()*10000 + this.writingResult.differenceFromGoal();
    }
    }

