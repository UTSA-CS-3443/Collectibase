package model;

/**
 * LaserDiscCollection is an extension of MoviesCollection and outlines the basic
 * variables needed for a LaserDisc Collection.
 * 
 * Title: The title of this LaserDisc.
 * Year: The year this LaserDisc was released.
 * Genre: The genre of this LaserDisc.
 * Format: The format of this Music collectible (LaserDisc).
 * Director: The director of this LaserDisc.
 * Special Edition: Whether this Laser Disc was part of a special edition (Anniversary, Unrated, etc.)
 * Encoding Format: The format in which this LaserDisc was encoded (CAV, CLV, CAA).
 * Region: The region this LaserDisc was produced. Different regions produce different formats. 
 * Sides: How many sides of the LaserDisc were written on. 
 * Cover: Whether this LaserDisc included an illustrated cover. 
 * 
 * @author Travis Lawson
 *
 */
public class LaserDiscCollection extends MoviesCollection {
	
	private String encodingFormat; //CAV, CLV, CAA
	private String region; // NTSC, JP, PAL
	private String sides; 
	private String cover;
	
	/******
	 * LaserDiscCollection's constructor prepared to handle empty fields. 
	 */
	public LaserDiscCollection() {
		super(" ", "0", " ", " ", " ", " ");
		this.encodingFormat = " ";
		this.region = " ";
		this.sides = " ";
		this.cover = " ";
	}
	
	/*******
	 * LaserDiscCollection's constructor prepared to handle fields with values. 
	 * @param title
	 * @param year
	 * @param genre
	 * @param format
	 * @param director
	 * @param specialEdition
	 * @param encodingFormat
	 * @param region
	 * @param sides
	 * @param cover
	 */
	public LaserDiscCollection(String title, String year, String genre, String format, String director, String specialEdition, String encodingFormat, String region, String sides,String cover ) {
		super(title, year, genre, format, director, specialEdition);
		this.encodingFormat = encodingFormat;
		this.region = region;
		this.sides = sides;
		this.cover = cover;
		
	}

	/******
	 * getEncodingFormat returns this LaserDisc's encoding format. 
	 * @return encodingFormat
	 */
	public String getEncodingFormat() {
		return encodingFormat;
	}

	/********
	 * setEncodingFormat sets this LaserDisc's encodingFormat.
	 * @param encodingFormat
	 */
	public void setEncodingFormat(String encodingFormat) {
		this.encodingFormat = encodingFormat;
	}
	
	/*******
	 * getRegion returns this LaserDisc's region value. 
	 * @return region
	 */
	public String getRegion() {
		return region;
	}

	/*********
	 * setRegion sets the region value for this LaserDisc.
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/********* 
	 * getSides returns the sides values for this LaserDisc.
	 * @return
	 */
	public String getSides() {
		return sides;
	}

	/********
	 * setSides sets the sides value for this LaserDisc.
	 * @param sides
	 */
	public void setSides(String sides) {
		this.sides = sides;
	}

	/********
	 * getCover returns the cover value for this LaserDisc.
	 * @return cover
	 */
	public String getCover() {
		return cover;
	}

	/*************
	 * setCover sets the value of this LaserDisc's cover.
	 * @param cover
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
}
