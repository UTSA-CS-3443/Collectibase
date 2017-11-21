package model;

/**
 * @author jesusnieto
 * @author Travis
 *
 */
public class DVDCollection extends MoviesCollection {

	private String caseType; //cardboard, plastic, jewel case, paper sleeve, generic.
	private String specialFeatDisc; //is a special features disc included. change to type boolean?
	private String criterion; // is the DVD part of the Criterion collection (printing and pressing of historical movies)
	private String spineNumber; // if  Criterion, the film will have a spine number
	
	/**
	 * Constructor for DVDCollection
	 * @param title
	 */
	public DVDCollection() {
		super("", "0", "", "", "", "");
		this.caseType = "";
		this.specialFeatDisc = "";
		this.criterion = "";
		this.spineNumber = "";
	}
	
	public DVDCollection(String title, String year, String genre, String format, String director, String specialEdition, String caseType, String specialFeatDisc, String criterion, String spineNumber ) {
		super(title, year, genre, format, director, specialEdition);
		this.caseType = caseType;
		this.specialFeatDisc = specialFeatDisc;
		this.criterion = criterion;
		this.spineNumber = spineNumber;
	}

	////////Getters and Setters\\\\\\\\
	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getSpecialFeatDisc() {
		return specialFeatDisc;
	}

	public void setSpecialFeatDisc(String specialFeatDisc) {
		this.specialFeatDisc = specialFeatDisc;
	}

	public String getCriterion() {
		return criterion;
	}

	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}

	public String getSpineNumber() {
		return spineNumber;
	}

	public void setSpineNumber(String spineNumber) {
		this.spineNumber = spineNumber;
	}

}
