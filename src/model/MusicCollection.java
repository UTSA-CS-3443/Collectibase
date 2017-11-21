package model;

public class MusicCollection {

	private String albumName; // artist
	// private String musicFormat; // type of format like cd, tape, etc.
	private String runningTime;
	private String artist;
	private String year;

	public MusicCollection(String artist, String year, String album, String runTime) {
		setArtist(artist); // maybe album name?
		setYear(year); // year the album was released
		setAlbum(album);
		setRunningTime(runTime);

		// this.albumName = albumName;
	}

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
