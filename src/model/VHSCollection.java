package model;

/**
 * 
 * VHSCollection is an extension of MoviesCollection and outlines
 * the basic variables needed for a VHS Collection. 
 * 
 * Title: The title of this VHS collectible. 
 * Year: The year this VHS collectible was released. 
 * Genre: The genre of this VHS collectible. 
 * Format: The format of this movie collectible (VHS).
 * Director: The director of this VHS collectible. 
 * Special Edition: Whether this VHS was part of a special edition (Anniversary, Unrated, etc.).
 * Home Recording: Whether this VHS was a home recording (taped from TV, home movie, etc.).
 * MultiProgram: If there are multiple programs on a single tape. 
 * MultiTape: If there are multiple tapes to this production (i.e too long to fit on one tape).
 * SleeveType: The type of material the sleeve is made out of (clamshell, plastic, cardboard, etc.).
 * 
 * @author Travis Lawson
 *
 */
public class VHSCollection extends MoviesCollection {

	private String homeRecording;
	private String multiProgram;
	private String multiTape; 
	private String sleeveType; 

	/**********
	 * VHSCollection's constructor prepared to handle empty fields. 
	 */
	public VHSCollection() {
		super(" ", "0"," ", " ", " ", " ");
		this.homeRecording = " ";
		this.multiProgram = " ";
		this.multiTape = " ";
		this.sleeveType = " ";
	}

	/******
	 * VHSCollection's constructor prepared to handle fields with values. 
	 * @param title
	 * @param genre
	 * @param format
	 * @param year
	 * @param director
	 * @param specialEdition
	 * @param homeRecordings
	 * @param multiProgram
	 * @param multiTape
	 * @param sleeveType
	 */
	public VHSCollection(String title, String genre, String format, String year, String director, String specialEdition, String homeRecordings, String multiProgram, String multiTape, String sleeveType ) {
		
		super(title, year, genre, format, director, specialEdition);
		this.homeRecording = homeRecordings;
		this.multiProgram = multiProgram;
		this.multiTape = multiTape;
		this.sleeveType = sleeveType;
		
	}
	
	/**
	 * getHomeRecording returns whether this VHS is a home recording. 
	 * @return homeRecording
	 */
	public String getHomeRecording() {
		return homeRecording;
	}

	/******
	 * setHomeRecording sets the value of this VHS's home recording to the
	 * specified parameter. 
	 * @param homeRecording
	 */
	public void setHomeRecording(String homeRecording) {
		this.homeRecording = homeRecording;
	}

	/********
	 * getMultiProgram returns whether this VHS is part of a multi-program. 
	 * @return multiProgram
	 */
	public String getMultiProgram() {
		return multiProgram;
	}

	/*********
	 * setMultiProgram sets the value of this VHS's multiProgram to
	 * the specified paramter.
	 * @param multiProgram
	 */
	public void setMultiProgram(String multiProgram) {
		this.multiProgram = multiProgram;
	}

	/**********
	 * getMultitape returns the value of this VHS' multiTape
	 * @return multiTape
	 */
	public String getMultiTape() {
		return multiTape;
	}

	/**********
	 * setMultiTape sets this VHS' multiTape to the specified parameter. 
	 * @param multiTape
	 */
	public void setMultiTape(String multiTape) {
		this.multiTape = multiTape;
	}

	/****
	 * getSleeveType returns the sleeve type for this VHS.
	 * @return sleeveType
	 */
	public String getSleeveType() {
		return sleeveType;
	}

	/******
	 * setSleeveType sets the sleeve type for this VHS to the specified parameter. 
	 * @param sleeveType
	 */
	public void setSleeveType(String sleeveType) {
		this.sleeveType = sleeveType;
	}

}
