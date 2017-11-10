package model;
// TODO: add toStrings

public class VHSCollection extends MoviesCollection implements Comparable<VHSCollection>{

	private String sleeveCondition;
	private String cassManufact; // who manufactured the
	private boolean homeRecording; // i.e. taped from tv or from another tape
	private boolean multiProgram; // if there are more the one programs on a single tape, primarily home
									// recordings
	private boolean multiTape; // VHS movies with multiple tapes, i.e Titanic and Gone With the Wind
	private boolean clamShell; // if the sleeve is a clamshell, i.e. sleeves that disney movies came in.

	// using constructor will make the parameters required
	public VHSCollection(String title, String year, String director, String format, String sleeve, String cassManufact,
			boolean homeRecording, boolean multiProgram, boolean multiTape, boolean clamShell) {
		super(title, year);
		setDirector(director);
		setFormat(format);
		this.sleeveCondition = sleeve;
		this.cassManufact = cassManufact;
		this.homeRecording = homeRecording;
		this.multiProgram = multiProgram;
		this.multiTape = multiTape;
		this.clamShell = clamShell;
	}
	
	public VHSCollection(String title) {
		super(title);
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

	public boolean isClamShell() {
		return clamShell;
	}

	public void setClamShell(boolean clamShell) {
		this.clamShell = clamShell;
	}

	@Override
	public int compareTo(VHSCollection arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
