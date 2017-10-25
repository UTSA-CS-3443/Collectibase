package model;

public class MusicCollection extends Collections{
	
	
	private String artist; // artist
	private String musicFormat; // type of format like cd, tape, etc.
	
	
	public MusicCollection(String albumName, String year) {
		setName(albumName); //maybe album name? 
		setYear(year); // year the album was released
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getMusicFormat() {
		return musicFormat;
	}
	
	public void setMusicFormat(String musicFormat) {
		this.musicFormat = musicFormat;
		
	}

}
