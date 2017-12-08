package model;

/**
 * MusicCollection is a parent class to Cassette, CD, and Vinyl. It holds
 * variables that each one of these classes have in common.
 * 
 * Artist: The artist of this music collectible. 
 * Year: The year this music collectible was released. 
 * Album: The album name of this music collectible. 
 * Run Time: The length of the music collectible with respect to time. 
 * 
 * @author Travis Lawson
 *
 */
public class MusicCollection {

	private String albumName; 
	private String runningTime; 
	private String artist; 
	private String year; 

	/****
	 * MusicCollection's constructor initializes the variables to the specified parameters.
	 * @param artist
	 * @param year
	 * @param album
	 * @param runTime
	 */
	public MusicCollection(String artist, String year, String album, String runTime) {
		setArtist(artist); // maybe album name?
		setAlbum(album);
		setYear(year); // year the album was released
		setRunningTime(runTime);
	}
	
	/***********
	 * getAlbum returns the album name of this music collectible. 
	 * @return albumName
	 */
	public String getAlbum() {
		return albumName;
	}

	/*********
	 * setAlbum sets this music collectible's albumName to the specified parameter. 
	 * @param albumName
	 */
	public void setAlbum(String album) {
		this.albumName = album;
	}

	/************
	 * getRunningTime returns the running time for this music collectible. 
	 * @return runningTime
	 */
	public String getRunningTime() {
		return runningTime;
	}

	/********
	 * setRunningTime sets the running time of this music collectible to the specified parameter. 
	 * @param runningTime
	 */
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	/**********
	 * getArtist returns the name of the artist for this music collectible. 
	 * @return artist
	 */
	public String getArtist() {
		return artist;
	}

	/*********
	 * setArtist sets the artist of this music collectible to the specified parameter. 
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**************
	 * getYear returns the year this music collectible was released.
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/*********
	 * setYear sets this music collectible's year to the given parameter.
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

}
