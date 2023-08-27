import java.util.LinkedList;

class MovieManager2 {

	MovieManager2() {
	}

	/**
	 * extracts a list of movies within a certain range of showtime
	 * @param movieList list of the movies to extract specific showtime range from
	 * @param lowerPar lower range of the period required
	 * @param higherPar hgiher rnage of the period required
	 * @return a list of movies that falls within the given parameter
	 */
	public LinkedList<Movie> organizeAccordingToParameter(LinkedList<Movie> movieList, int lowerPar, int higherPar) {
		LinkedList<Movie> listOfMovies = new LinkedList<Movie>(); //creates a list
		for (Movie aMovie : movieList) { //loops over the data list
			if(aMovie.simulcast==false) {
				if (lowerPar <= aMovie.showtime && aMovie.showtime < higherPar) { // adds the movie if its within the range
					listOfMovies.add(aMovie);
				}
			}
		}
		return listOfMovies;
	}

	/**
	 * organizes the movies into their repective list according to their showtime
	 * @param movies list of movies
	 * @return programme that has three different list of movies based on their showtimne
	 */
	public Programme organizeMovies(LinkedList<Movie> movies) {
		LinkedList<Movie> matinee = organizeAccordingToParameter(movies,700,1200); //list of morning movies
		LinkedList<Movie> primetime = organizeAccordingToParameter(movies,1200,2000); //list of afternoon movies
		LinkedList<Movie> soiree = new LinkedList<Movie>(); //list of evening movies
		for (Movie aMovie : movies) { // loops over the data
			if(aMovie.simulcast==false) { //makes sure its not a simulcast
				if (2000 <= aMovie.showtime || aMovie.showtime < 200) { //adds it to the evening list if they are within the range
					soiree.add(aMovie);
				}
			}
		}

		return new Programme(matinee,primetime,soiree);
	}
	
}
