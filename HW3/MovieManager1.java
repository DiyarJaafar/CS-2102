import java.util.LinkedList;

class MovieManager1 {
	
	MovieManager1() {}

	/**
	 * Organizes a list of movies into a Programme object
	 * Creates three LinkedList objects containing the non-simulcast matinees, primetimes, and soirees and
	 * returns a constructed Programme object with all three lists
	 * @param movies - list of movies to be organized
	 */
	public Programme organizeMovies(LinkedList<Movie> movies) {
		Programme organizedProgramme = new Programme();
		//loops through every movie in the list
		for (Movie aMovie: movies){
			// checking if it is not a simulcast
			if (aMovie.simulcast==false){
				//adds the movie to matinee if it is between 7am and 12pm
				if (700<=aMovie.showtime && aMovie.showtime<1200){
					organizedProgramme.matinee.add(aMovie);
				}//adds the movie to primetime if it is between 12pm and 8pm
				else if (1200<=aMovie.showtime &&aMovie.showtime<2000) {
					organizedProgramme.primetime.add(aMovie);
				}//adds it to soiree otherwise
				else {
					organizedProgramme.soiree.add(aMovie);
				}
			}
		}
		return organizedProgramme;
	}
}
