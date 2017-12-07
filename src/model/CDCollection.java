package model;

/**
 * 
 * CDCollection is an extension of MusicCollection. The CDCollection holds
 * variable that are more specific to the CD format.
 * 
 * @author Jesus
 * @author Travis
 *
 */
public class CDCollection extends MusicCollection {

	private String multiCD;// albums with multiple CDs
	private String poster; // albums that came with posters
	private String enhancedCD; // deluxe edition, additional media, etc....

	//////// constructors ////////
	public CDCollection() {
		super(" ", " ", " ", " ");
		this.multiCD = " ";
		this.poster = " ";
		this.enhancedCD = " ";
	}

	public CDCollection(String artist, String year, String album, String runtime, String multiCD, String poster,
			String enhancedCD) {
		super(artist, album, year, runtime);
		this.multiCD = multiCD;
		this.poster = poster;
		this.enhancedCD = enhancedCD;
	}

	//////// getters and setters ////////
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
