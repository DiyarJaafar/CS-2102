public class Literarian {

    ChallengeResult challengeResult;
    public Literarian(ChallengeResult challengeResult){
        this.challengeResult = challengeResult;
    }
    public boolean betterBookworm(Literarian other){
      if (this.challengeResult.readingResult.differenceFromGoal()<other.challengeResult.readingResult.differenceFromGoal())
          return true;
          else return false;
    }

    public boolean wittierWordsmith (Literarian other){
        return this.challengeResult.writingResult.averagePerDay()>other.challengeResult.writingResult.averagePerDay();
    }

    public boolean successfulScholar (Literarian other){
        if(this.betterBookworm(other) || this.wittierWordsmith(other))
        {
            return true;
        }
        else
        {
            return false;
        }    }

    public Literarian(double booksReadFiction, double booksReadNonfiction, int goalBooksPerDay, double wordsWritten, int day)
    {
        this.challengeResult = new ChallengeResult(new ReadingResult(goalBooksPerDay, new BooksRead(booksReadFiction), new BooksRead(booksReadNonfiction)), new WritingResult(wordsWritten, day));
    }

}

