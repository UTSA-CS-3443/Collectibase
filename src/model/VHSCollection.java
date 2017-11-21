package model;
// TODO: add toStrings

public class VHSCollection extends MoviesCollection /* implements Comparable<VHSCollection> */ {

	private String homeRecording; // i.e. taped from tv, other tapes, home movies, etc..
	private String multiProgram; // if there are more the one programs on a single tape, primarily home
									// recordings
	private String multiTape; // VHS movies with multiple tapes, i.e Titanic and Gone With the Wind
	private String sleeveType; // clamshell, plastic, cardboard.

	public VHSCollection() {
		super("", 0,"", "", "", "");
		this.homeRecording = "";
		this.multiProgram = "";
		this.multiTape = "";
		this.sleeveType = "";
	}

	public VHSCollection(String title, String genre, String format, int year, String director, String specialEdition, String homeRecordings, String multiProgram, String multiTape, String sleeveType ) {
		
		super(title, year, genre, format, director, specialEdition);
		this.homeRecording = homeRecordings;
		this.multiProgram = multiProgram;
		this.multiTape = multiTape;
		this.sleeveType = sleeveType;
		
	}
	
	/**
	 * compareTo method used to alphabetize the ArrayList
	 */
	/*
	 * public int compareTo(VHSCollection vhs) { if (this.getName() != null &&
	 * vhs.getName() != null) { return
	 * this.getName().compareToIgnoreCase(vhs.getName()); } return 0; } public
	 * String toString() { return String.format("%s", getName()); }
	 */
	//////// getters and setters////////
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
