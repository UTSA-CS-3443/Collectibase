package model;

/**
 * MoviesCollection is a parent class to DVD, LasesrDisc, and VHS. It holds
 * variables that each one of these classes have in common.
 * 
 * @author Travis
 *
 */
public class MoviesCollection {

	private String format;
	private String director;
	private String specialEdition;
	private String title;
	private String genre;
	private String year;

	//////// constructor ////////
	public MoviesCollection(String title, String year, String genre, String format, String director,
			String specialEdition) {
		setTitle(title);
		setYear(year);
		setGenre(genre);
		this.format = format;
		this.director = director;
		this.specialEdition = specialEdition;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
