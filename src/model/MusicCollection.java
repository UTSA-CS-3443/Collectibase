package model;

public class MusicCollection extends Collections{
	
	
	private String albumName; // artist
	private String musicFormat; // type of format like cd, tape, etc.
	
	
	public MusicCollection(String artist, String year) {
		setName(artist); //maybe album name? 
		setYear(year); // year the album was released
		//this.albumName = albumName;
		
	}
	
	public MusicCollection(String artist) {
		setName(artist);		
	}
	
	public String getAlbum() {
		return albumName;
	}
	
	public void setAlbum(String album) {
		this.albumName = album;
	}
	
	public String getMusicFormat() {
		return musicFormat;
	}
	
	public void setMusicFormat(String musicFormat) {
		this.musicFormat = musicFormat;
		
	}

}
