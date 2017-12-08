package model;

/**
 * 
 * CDCollection extends MusicCollection and outlines basic variables needed for
 * a CD Collection
 *
 * Artist: The name of the artist of the CD.
 * Year: The year the CD was released. 
 * Album: The name of the album of the CD. 
 * Running Time: The length of the CD with respect to time. 
 * MultiCD: Whether there are multiple CD's included with this release.
 * Poster: Whether a poster was included with this CD's release. 
 * Enhanced CD: Whether this CD was certified to be made with special audio technology. 
 * 
 * @author Jesus Nieto
 * @author Travis Lawson
 *
 */
public class CDCollection extends MusicCollection {

	private String multiCD;
	private String poster; 
	private String enhancedCD; 

	/******
	 * CDCollection's constructor prepared to handle empty fields.
	 */
	public CDCollection() {
		super(" ", " ", " ", " ");
		this.multiCD = " ";
		this.poster = " ";
		this.enhancedCD = " ";
	}

	/*********8
	 * CDCollection's constructor prepared to handle fields with values. 
	 * @param artist
	 * @param year
	 * @param album
	 * @param runtime
	 * @param multiCD
	 * @param poster
	 * @param enhancedCD
	 */
	public CDCollection(String artist, String year, String album, String runtime, String multiCD, String poster,
			String enhancedCD) {
		super(artist, album, year, runtime);
		this.multiCD = multiCD;
		this.poster = poster;
		this.enhancedCD = enhancedCD;
	}

	/*****
	 * getMultiCD returns whether this CD has multiple CD's in it's release. 
	 * @return multiCD
	 */
	public String getMultiCD() {
		return multiCD;
	}

	/*********
	 * setMultiCD sets the value for multiCD.
	 * @param multiCD
	 */
	public void setMultiCD(String multiCD) {
		this.multiCD = multiCD;
	}

	/*******
	 * getPoster returns whether this CD release contained a poster.
	 * @return poster
	 */
	public String getPoster() {
		return poster;
	}

	/***********
	 * setPoster sets the value for Poster
	 * @param poster
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}

	/**********
	 * getEnhancedCD returns whether this CD was an enhanced CD.
	 * @return enhancedCD
	 */
	public String getEnhancedCD() {
		return enhancedCD;
	}

	/*********
	 * setEnhancedCD sets the value for enhancedCD
	 * @param enhancedCD
	 */
	public void setEnhancedCD(String enhancedCD) {
		this.enhancedCD = enhancedCD;
	}

}
