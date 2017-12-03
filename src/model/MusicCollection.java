package model;

/**
 * MusicCollection is a parent class to Cassette, CD, and Vinyl. It holds
 * variables that each one of these classes have in common.
 * 
 * @author Travis
 *
 */
public class MusicCollection {

	private String albumName; // name of a given album
	private String runningTime; // length of a given album
	private String artist; // artist of a given album
	private String year; // release of a given album

	//////// constructors ////////
	public MusicCollection(String artist, String year, String album, String runTime) {
		setArtist(artist); // maybe album name?
		setAlbum(album);
		setYear(year); // year the album was released
		setRunningTime(runTime);
	}
	
	//////// getters and setters ////////
	public String getAlbum() {
		return albumName;
	}

	public void setAlbum(String album) {
		this.albumName = album;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
