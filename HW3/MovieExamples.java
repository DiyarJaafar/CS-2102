import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MovieExamples
{
	MovieManager1 mm1 = new MovieManager1();
	LinkedList<Movie> movies = new LinkedList<Movie>();
	Programme programme1 = new Programme();
	LinkedList<Movie> studentTest = new LinkedList<Movie>();
	Programme studentTestProgramme = new Programme();


	Movie starTrek = new Movie("Star Trek Into Darkness", 1400, 132, false);
	Movie pinicchio = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
	Movie swampThing = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
	Movie sevenSamurai = new Movie("Seven Samurai", 0, 207, false);
	Movie movieOne = new Movie("movieOne", 700, 90, false);
	Movie movieTwo = new Movie("movieTwo", 2000, 110, false);
	Movie movieThree = new Movie("movieThree", 0, 105, false);
	Movie movieFour = new Movie("movieFour", 1200, 125, false);


	public MovieExamples()
	{
		movies.add(starTrek);
		programme1.primetime.add(starTrek);

		movies.add(pinicchio);
		programme1.matinee.add(pinicchio);

		movies.add(swampThing);
		programme1.soiree.add(swampThing);

		movies.add(sevenSamurai);
		programme1.soiree.add(sevenSamurai);

		studentTest.add(starTrek);
		studentTestProgramme.primetime.add(starTrek);
		studentTest.add(pinicchio);
		studentTestProgramme.matinee.add(pinicchio);
		studentTest.add(sevenSamurai);
		studentTestProgramme.soiree.add(sevenSamurai);
		studentTest.add(movieOne);
		studentTestProgramme.matinee.add(movieOne);
		studentTest.add(movieTwo);
		studentTestProgramme.soiree.add(movieTwo);
		studentTest.add(movieThree);
		studentTestProgramme.soiree.add(movieThree);
		studentTest.add(movieFour);
		studentTestProgramme.primetime.add(movieFour);
	}

	@Test
	public void instructorTestProgramme_EmptyReport() {
		Programme report2 = new Programme();
		assertFalse(programme1.equals(report2));
	}


	@Test
	public void instructorTestProgramme_WrongOrder() {
		Programme programme2 = new Programme();

		programme2.primetime.add(starTrek);
		programme2.matinee.add(pinicchio);
		programme2.soiree.add(sevenSamurai);
		programme2.soiree.add(swampThing);


		assertFalse(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_DifferentInstances() {
		Programme programme2 = new Programme();

		Movie starTrek2 = new Movie("Star Trek Into Darkness", 1400, 132, false);
		Movie pinocchio2 = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
		Movie swampThing2 = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
		Movie sevenSamurai2 = new Movie("Seven Samurai", 0, 207, false);

		programme2.primetime.add(starTrek2);
		programme2.matinee.add(pinocchio2);
		programme2.soiree.add(swampThing2);
		programme2.soiree.add(sevenSamurai2);

		assertTrue(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_SameInstances() {
		Programme programme2 = programme1;
		assertTrue(programme1.equals(programme2));
	}


	@Test
	public void instructorTestOrganizeMovies()
	{
		Programme programme2 = mm1.organizeMovies(movies);
		programme1.soiree.remove(swampThing); //it's a simulcast
		assertEquals(programme1, programme2);
	}
	@Test
	public void studentTestOrganizingMovies()
	{
		Programme comparingProgramme = mm1.organizeMovies(studentTest);
		assertEquals(studentTestProgramme, comparingProgramme);
	}
	@Test
	public void studentTestOrganizingMovies1()
	{
		studentTestProgramme.soiree.remove(movieTwo);
		studentTestProgramme.soiree.remove(movieThree);
		movieTwo.simulcast = true;
		movieThree.showtime = 1130.0;
		studentTestProgramme.matinee.add(movieThree);
		Programme comparingProgramme = mm1.organizeMovies(studentTest);
		assertEquals(studentTestProgramme, comparingProgramme);
	}

}

//subtask
//		create a programme
//		go through every movie
//		check every movie showtime
//		add them to their respective list in the program
//		return programme