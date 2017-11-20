package model;

/**
 * Testing a new way for CD collection
 * @author jesusnieto
 *
 */
public class CDTestCollection {
	private String artist;
	private String album;
	private String runningTime;
	private String multiCD;
	private String poster;
	private String enhancedCD;
	
	public CDTestCollection() {
		this.artist = "";
		this.album = "";
		this.runningTime = "";
		this.multiCD = "";
		this.poster = "";
		this.enhancedCD = "";
	}
	
	public CDTestCollection(String artist, String album, String runningTime, String multiCD, String poster, String enhancedCD) {
		this.artist = artist;
		this.album = album;
		this.runningTime = runningTime;
		this.multiCD = multiCD;
		this.poster = poster;
		this.enhancedCD = enhancedCD;
		
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getMultiCD() {
		return multiCD;
	}

	public void setMultiCD(String multiCD) {
		this.multiCD = multiCD;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getEnhancedCD() {
		return enhancedCD;
	}

	public void setEnhancedCD(String enhancedCD) {
		this.enhancedCD = enhancedCD;
	}
	
	
	
	

}
