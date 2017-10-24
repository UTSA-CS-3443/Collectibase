package model;

/**
 *  The collections class contains general information that all collections have in common.
 
 * @author Travis
 *
 */

public abstract class Collections {
	/**
	 * common traits that all collections share
	 */
	private String name;
	private String rarity;
	private String genre;
	private String condition;
	private String year; 
	private double value;

	//////// Getters and Setters////////
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
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
