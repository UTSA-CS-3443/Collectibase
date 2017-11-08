package model;

public class CDCollection extends MusicCollection{

	

	private String multiCDAlbums;//albums with multiple CDs
	private String posters; // albums that came with posters
	private String enhancedCDs; // deluxe edition, additional media, etc.... 
	
	public CDCollection(String artist, String year,String albumName, String format) {
		super(artist, year);
		setAlbum(albumName);
		setMusicFormat(format);
		//setMusicFormat(format);
		// TODO Auto-generated constructor stub
	}

	public String getMultiCDAlbums() {
		return multiCDAlbums;
	}

	public void setMultiCDAlbums(String multiCDAlbums) {
		this.multiCDAlbums = multiCDAlbums;
	}

	public String getPosters() {
		return posters;
	}

	public void setPosters(String posters) {
		this.posters = posters;
	}

	public String getEnhancedCDs() {
		return enhancedCDs;
	}

	public void setEnhancedCDs(String enhancedCDs) {
		this.enhancedCDs = enhancedCDs;
	}
	

}
