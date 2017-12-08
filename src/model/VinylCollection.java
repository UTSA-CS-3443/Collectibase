package model;

/**
 * VinylCollection is an extension of MusicCollection and outlines
 * the basic variables needed for a Vinyl Collection.
 * 
 * Artist: The artist of this vinyl. 
 * Year: The year this vinyl was released. 
 * Album: The album name of this vinyl. 
 * Run Time: The length of this vinyl with respect to time. 
 * Size: The disc size of this vinyl.
 * Color: The color of the disc of this vinyl.
 * Speed: The speed of the vinyl given in rotations per minute (rpm).
 * 
 * @author Travis Lawson
 *
 */
public class VinylCollection extends MusicCollection {

	private String size; 
	private String color; 
	private String speed; 

	/*******
	 * VinylCollection's constructor prepared to handle empty fields. 
	 */
	public VinylCollection() {
		super(" ", "0", " ", "0");
		this.size = "";
		this.color = "";
		this.speed = "";
	}

	/*********
	 * VinylCollection's constructor prepared to handle fields with values. 
	 * @param artist
	 * @param year
	 * @param album
	 * @param runTime
	 * @param size
	 * @param color
	 * @param speed
	 */
	public VinylCollection(String artist, String year, String album, String runTime, String size, String color,
			String speed) {
		super(artist, year, album, runTime);
		this.size = size;
		this.color = color;
		this.speed = speed;

	}

	/********
	 * getSize returns the size of this vinyl.
	 * @return size
	 */
	public String getSize() {
		return size;
	}

	/***
	 * setSize sets the size of this vinyl to the specified parameter.
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/***
	 * getColor returns the color of this vinyl disc. 
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/***
	 * setColor sets the color of this vinyl to the specified parameter.
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/****
	 * getSpeed returns the speed of this vinyl.
	 * @return speed
	 */
	public String getSpeed() {
		return speed;
	}

	/***
	 * setSpeed sets the speed of this vinyl to the specified paramter. 
	 * @param speed
	 */
	public void setSpeed(String speed) {
		this.speed = speed;
	}

}
