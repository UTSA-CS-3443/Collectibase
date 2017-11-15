package model;

/**
 * 
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
	public DVDCollection(String title) {
		super(title);
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
