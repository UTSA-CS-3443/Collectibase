package model;

public class VHSCollection extends MoviesCollection {
	private String sleeveCondition;
	private String cassManufact; // who manufactured the
	private boolean homeRecording; // i.e. taped from tv or from another tape
	private boolean multiProgram; // if there are more the one programs on a single tape, primarily home
									// recordings
	private boolean multiTape; // VHS movies with multiple tapes, i.e Titanic and Gone With the Wind

	public VHSCollection(String title, String director, String year, String format, String sleeve) {
		super(title);
		setDirector(director);
		setYear(year);
		setFormat(format);
		this.sleeveCondition = sleeve;
	}

	//////// getters and setters////////
	public String getSleeveCondition() {
		return sleeveCondition;
	}

	public void setSleeveCondition(String sleeveCondition) {
		this.sleeveCondition = sleeveCondition;
	}

	public String getCassManufact() {
		return cassManufact;
	}

	public void setCassManufact(String cassetteManufact) {
		this.cassManufact = cassetteManufact;
	}

	public boolean isHomeRecording() {
		return homeRecording;
	}

	public void setHomeRecording(boolean homeRecording) {
		this.homeRecording = homeRecording;
	}

	public boolean isMultiProgram() {
		return multiProgram;
	}

	public void setMultiProgram(boolean multiProgram) {
		this.multiProgram = multiProgram;
	}

	public boolean isMultiTape() {
		return multiTape;
	}

	public void setMultiTape(boolean multiTape) {
		this.multiTape = multiTape;
	}

}
