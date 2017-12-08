package model;

/**
 * MoviesCollection is a parent class to DVD, LasesrDisc, and VHS. It holds
 * variables that each one of these classes have in common.
 * 
 * Title: The title of this movie collectible. 
 * Year: The year this movie collectible was released. 
 * Genre: The genre of this movie collectible. 
 * Format: The format of this movie collectible (DVD, VHS, LD)
 * Director: The director of this movie collectible. 
 * Special Edition: Whether this movie collectible was part of a special edition. 
 * 
 * @author Travis Lawson
 *
 */
public class MoviesCollection {

	private String format;
	private String director;
	private String specialEdition;
	private String title;
	private String genre;
	private String year;

	/*************
	 * MoviesCollection's constructor initializes it's variables with specified parameters. 
	 * @param title
	 * @param year
	 * @param genre
	 * @param format
	 * @param director
	 * @param specialEdition
	 */
	public MoviesCollection(String title, String year, String genre, String format, String director,
			String specialEdition) {
		setTitle(title);
		setYear(year);
		setGenre(genre);
		this.format = format;
		this.director = director;
		this.specialEdition = specialEdition;
	}

	/*********
	 * getFormat returns the format for this specified movie collectible. 
	 * @return format
	 */
	public String getFormat() {
		return format;
	}

	/*********
	 * setFormat sets the format for this movie collectible. 
	 * @param format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**********
	 * getDirector returns the director for this movie collectible. 
	 * @return director
	 */
	public String getDirector() {
		return director;
	}

	/*********
	 * setDirector sets the director for this specified movie collectible. 
	 * @param director
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/*********
	 * getSpecialEdition returns whether this movie collectible was part of a special edition. 
	 * @return specialEdition
	 */
	public String getSpecialEdition() {
		return specialEdition;
	}

	/*******
	 * setSpecialEdition sets the value of this movie collectible's special edition to the
	 * specified parameter. 
	 * @param specialEdition
	 */
	public void setSpecialEdition(String specialEdition) {
		this.specialEdition = specialEdition;
	}

	/***********
	 * getTitle returns the title of this movie collectible.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/*******
	 * setTitle sets the title for this movie collectible. 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*********
	 * getYear returns the year this movie collectible was released. 
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**********
	 * setYear sets the year of this movie collectible to the specified parameter. 
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/***********
	 * getGenre returns the genre of this movie collectible.
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}

	/********
	 * setGenre sets the genre of this movie collectible to the specified parameter. 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
