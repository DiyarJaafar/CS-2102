import java.util.LinkedList;

class Programme {
	
	LinkedList<Movie> matinee;
	LinkedList<Movie> primetime;
	LinkedList<Movie> soiree;
	
	Programme()
	{
		this.matinee = new LinkedList<Movie>();
		this.primetime = new LinkedList<Movie>();
		this.soiree = new LinkedList<Movie>();
	}
	
	Programme(LinkedList<Movie> matinee, LinkedList<Movie> primetime, LinkedList<Movie> soiree)
	{
		this.matinee = matinee;
		this.primetime = primetime;
		this.soiree = soiree;
	}

	/**
	 * comapres two movie lists for their title and showtime
	 * @param original the calling class linked list
	 * @param compared another list for comaprision
	 * @return true if they have same title and showtime
	 */
	public boolean compareTwoListsObjects (LinkedList<Movie> original,LinkedList<Movie> compared){
		for (int i = 0; i<original.size();i++){
			if(!original.get(i).title.equals(compared.get(i).title) || original.get(i).showtime!=compared.get(i).showtime){
				return false;
			}
		}
		return true;
	}

	/**
	 * overrides the object equals method to fit the instructed definition
	 * @param obj takes in a programme objest
	 * @return true if they are equal according to the instructed definition (same size and mvoies(same title and showtime))
	 */
	public boolean equals(Object obj){
		Programme other = (Programme) obj;
		if(this.matinee.size()==other.matinee.size()&&this.primetime.size()==other.primetime.size()&&this.soiree.size()==other.soiree.size()){
			if (this.compareTwoListsObjects(this.matinee,other.matinee)&&
				this.compareTwoListsObjects(this.primetime,other.primetime)&&
				this.compareTwoListsObjects(this.soiree,other.soiree)){
				return true;
			}
		}
		return false;
	}


}
