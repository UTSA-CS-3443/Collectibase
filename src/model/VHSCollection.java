package model;
// TODO: add toStrings

public class VHSCollection extends MoviesCollection implements Comparable<VHSCollection> {

	private String sleeveCondition;
	private String homeRecording; // i.e. taped from tv, other tapes, home movies, etc..
	private String multiProgram; // if there are more the one programs on a single tape, primarily home
									// recordings
	private String multiTape; // VHS movies with multiple tapes, i.e Titanic and Gone With the Wind
	private String clamShell; // if the sleeve is a clamshell, i.e. cases that disney movies came in.

	public VHSCollection(String title) {
		super(title);
	}

	/**
	 * compareTo method used to alphabetize the ArrayList
	 */
	public int compareTo(VHSCollection vhs) {
		if (this.getName() != null && vhs.getName() != null) {
			return this.getName().compareToIgnoreCase(vhs.getName());
		}
		return 0;
	}

	//////// getters and setters////////
	public String getSleeveCondition() {
		return sleeveCondition;
	}

	public void setSleeveCondition(String sleeveCondition) {
		this.sleeveCondition = sleeveCondition;
	}

	public String getHomeRecording() {
		return homeRecording;
	}

	public void setHomeRecording(String homeRecording) {
		this.homeRecording = homeRecording;
	}

	public String getMultiProgram() {
		return multiProgram;
	}

	public void setMultiProgram(String multiProgram) {
		this.multiProgram = multiProgram;
	}

	public String getMultiTape() {
		return multiTape;
	}

	public void setMultiTape(String multiTape) {
		this.multiTape = multiTape;
	}

	public String getClamShell() {
		return clamShell;
	}

	public void setClamShell(String clamShell) {
		this.clamShell = clamShell;
	}
}
