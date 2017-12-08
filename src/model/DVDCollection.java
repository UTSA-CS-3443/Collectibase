package model;

/**
 * DVDCollection extends MoviesCollection and outlines basic variables 
 * needed for a DVDCollection. 
 * 
 * Title: The title of this DVD.
 * Year: The year this DVD was released. 
 * Genre: The genre of this DVD. 
 * Format: The specified format of this movie collectible (DVD).
 * Director: The director of this DVD.
 * Special Edition: Whether this DVD was part of a special edition (Anniversary edition, Unrated, etc)
 * Case Type: The case type of this DVD (cardboard, plastic, jewel case, etc).
 * Special Featuring: Whether this DVD includes special features. 
 * Criterion: Whether this DVD was part of a criterion collection (printing and pressing of historical movies).
 * Spine Number: If the DVD is part of a criterion, then it will include a spine number. 
 * 
 * @author Jesus Nieto
 * @author Travis Lawson
 *
 */
public class DVDCollection extends MoviesCollection {

	private String caseType; 
	private String specialFeaturing; 
	private String criterion; 
	private String spineNumber; 
	
	/********
	 * DVDCollection's constructor prepared to handle empty fields. 
	 */
	public DVDCollection() {
		super(" ", "0", " ", " ", " ", " ");
		this.caseType = " ";
		this.specialFeaturing = " ";
		this.criterion = " ";
		this.spineNumber = " ";
	}
	
	/**********
	 * DVDCollection's constructor prepared to handle fields with values. 
	 * @param title
	 * @param year
	 * @param genre
	 * @param format
	 * @param director
	 * @param specialEdition
	 * @param caseType
	 * @param specialFeatDisc
	 * @param criterion
	 * @param spineNumber
	 */
	public DVDCollection(String title, String year, String genre, String format, String director, String specialEdition, String caseType, String specialFeatDisc, String criterion, String spineNumber ) {
		super(title, year, genre, format, director, specialEdition);
		this.caseType = caseType;
		this.specialFeaturing = specialFeatDisc;
		this.criterion = criterion;
		this.spineNumber = spineNumber;
	}

	/*********
	 * getCaseType returns the type of case for this DVD.
	 * @return caseType
	 */
	public String getCaseType() {
		return caseType;
	}

	/**********
	 * setCaseType sets the type of case for this DVD. 
	 * @param caseType
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	/*******
	 * getSpecialFeaturing returns whether this DVD contains any special features. 
	 * @return specialFeaturing
	 */
	public String getSpecialFeaturing() {
		return specialFeaturing;
	}

	/*******
	 * setSpecialFeaturing sets whether this DVD contains any special features. 
	 * @param specialFeatDisc
	 */
	public void setSpecialFeaturing(String specialFeatDisc) {
		this.specialFeaturing = specialFeatDisc;
	}

	/********
	 * getCriterion returns whether this DVD was part of a criterion collection.
	 * @return criterion
	 */
	public String getCriterion() {
		return criterion;
	}

	/**********
	 * setCriterion sets DVD's criterion to the value passed in
	 * @param criterion
	 */
	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}

	/********
	 * getSpineNumber returns this DVD's spine number (if it has one).
	 * @return spineNumber
	 */
	public String getSpineNumber() {
		return spineNumber;
	}

	/*********
	 * setSpineNumber sets the spine number for this DVD.
	 * @param spineNumber
	 */
	public void setSpineNumber(String spineNumber) {
		this.spineNumber = spineNumber;
	}

}
