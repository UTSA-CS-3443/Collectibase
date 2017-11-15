package model;

/**
 *  The collections class contains general information that all collections have in common.
 
 * @author Travis
 *
 */

public abstract class Collections {
	/**
	 * Some common traits that all collections share
	 */
	private String name;
	private String genre;
	private String year; 
	

	//////// Getters and Setters////////
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
