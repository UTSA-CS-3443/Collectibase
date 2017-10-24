package model;

public class MoviesCollection extends Collections {

	// possible variables: awardWinning
	
	private String format;
	private String director;
	private String specialEdition; // possible boolean?

	public MoviesCollection(String title, String year) {
		setName(title);
		setYear(year);
	}

	////////// getters and setters//////////
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSpecialEdition() {
		return specialEdition;
	}

	public void setSpecialEdition(String specialEdition) {
		this.specialEdition = specialEdition;
	}


}
