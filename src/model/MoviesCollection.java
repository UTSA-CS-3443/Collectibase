package model;

public class MoviesCollection extends Collections {

	// possible variables: awardWinning
	
	private String format;
	private String director;
	private String year;

	public MoviesCollection(String title) {
		setName(title);
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
