package model;

public class CDCollection extends MusicCollection{

	
	public CDCollection(String artist, String albumName, String year, String musicFormat) {
		super(artist, year);
		setAlbum(albumName);
		setMusicFormat(musicFormat);
	}
	
	public CDCollection(String artist, String album) {
		super(artist);
		setAlbum(album);
	}

}
