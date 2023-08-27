import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
    //Test Literarians
    Literarian Daniel = new Literarian(1.5, 4.0, 1, 4000, 10);
    Literarian Diyar = new Literarian(1.1,2.0,3,7500,10);

    //Construtor
    public Examples(){}

    //Check that both literarians have the same last updated day
    @Test
    public void checkSameDay()
    {
        assertTrue(Daniel.challengeResult.writingResult.dayOfNovUpdate == Diyar.challengeResult.writingResult.dayOfNovUpdate);
    }

    //Checks functionality of Literarian.betterBookworm() method
    @Test
    public void danielBookworm()
    {
        assertTrue(Daniel.betterBookworm(Diyar));
    }

    //Checks functionality of Literarian.witterWordsmith() method
    @Test
    public void diyarWordsmith()
    {
        assertTrue(Diyar.wittierWordsmith(Daniel));
    }

    //Tests functionality of Literarian.successfulScholar() method
    @Test
    public void danielScholar()
    {
        assertTrue(Daniel.successfulScholar(Diyar));
    }
}