package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * testing anew way for the collections
 * @author jesusnieto
 *
 */
public class VHSTestCollection {
	private String title;
	private String genre;
	private String format;
	private int year;
	private String director;
	private String specialEdition;
	private String homeRecording;
	private String multiProgram;
	private String multiTape;
	private String sleeveType;
	
	
	public VHSTestCollection() {
		this.title = "";
		this.genre = "";
		this.format = "";
		this.year = 0;
		this.director = "";
		this.specialEdition = "";
		this.homeRecording = "";
		this.multiProgram = "";
		this.multiTape = "";
		this.sleeveType = "";
		
	}
	
	public VHSTestCollection(String title, String genre, String format, int year, String director, String specialEdition, String homeRecordings, String multiProgram, String multiTape, String sleeveType ) {
		
		this.title = title;
		this.genre = genre;
		this.format = format;
		this.year = year;
		this.director = director;
		this.specialEdition = specialEdition;
		this.homeRecording = homeRecordings;
		this.multiProgram = multiProgram;
		this.multiTape = multiTape;
		this.sleeveType = sleeveType;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public String getHomeRecording() {
		return homeRecording;
	}

	public void setHomeRecording(String homeRecording) {
		this.homeRecording = homeRecording;
	}

	public String getMultiProgram() {
		return multiProgram;
	}

	public void setMultiProgram(String multiProgram) {
		this.multiProgram = multiProgram;
	}

	public String getMultiTape() {
		return multiTape;
	}

	public void setMultiTape(String multiTape) {
		this.multiTape = multiTape;
	}

	public String getSleeveType() {
		return sleeveType;
	}

	public void setSleeveType(String sleeveType) {
		this.sleeveType = sleeveType;
	}
	
}
