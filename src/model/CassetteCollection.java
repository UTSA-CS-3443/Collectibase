package model;
/****
 * 
 * CassetteCollection extends MusicCollection and outlines the basic variables needed for a Cassette collection.
 * 
 * Artist: The name of the artist of the cassette.
 * Year: The year the cassette was released. 
 * Album: The name of the album of the cassette. 
 * Running Time: The length of the cassette with respect to time. 
 * Type: Cassettes come in different types (Type 1, 2, 3, 4, or other)/
 * Write Protection: Specifies whether this cassette has a write protection which
 * 		prohibits it from being overwritten. 
 * Audio Output: Specifies whether the audio output is stero or mono.
 * Endless Loop: Specifies whether the cassette loops back to enable endless playing. 
 * 
 * @author Brenda Trejo
 * 
 * @debugger: Travis Lawson
 */

public class CassetteCollection extends MusicCollection {
	
	private String type; // Type 1, 2, 3, 4, or other
	private String writeProtection;
	private String audioOutput;
	private String endlessLoop;
	
	/**********
	 * CassetteCollection's constructor prepared to handle empty fields.
	 */
	public CassetteCollection() {

		super(" ","0"," "," ");
		this.type = " ";
		this.writeProtection = " ";
		this.audioOutput = " ";
		this.endlessLoop = " ";
	}
	
	/**********
	 * CassetteCollection's constructor prepared to handle fields with values. 
	 * @param artist
	 * @param year
	 * @param album
	 * @param runningTime
	 * @param type
	 * @param writeProtection
	 * @param audioOutput
	 * @param endlessLoop
	 */
	public CassetteCollection(String artist, String year, String album, String runningTime, String type, String writeProtection, String audioOutput, String endlessLoop) {
		super(artist, year, album, runningTime);
		this.type = type;
		this.writeProtection = writeProtection;
		this.audioOutput = audioOutput;
		this.endlessLoop = endlessLoop;
	}

	/*******
	 * getType returns the type of this cassette. 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/*****
	 * setType sets the type for this cassette.
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/***********
	 * getWriteProtection returns the writeProtection for this cassette. 
	 * @return writeProtection
	 */
	public String getWriteProtection() {
		return writeProtection;
	}

	/******
	 * setWriteProtection sets the writeProtection for this cassette. 
	 * @param writeProtection
	 */
	public void setWriteProtection(String writeProtection) {
		this.writeProtection = writeProtection;
	}

	/*********
	 * getAudioOutput returns the audioOutput setting for this cassette.
	 * @return audioOutput
	 */
	public String getAudioOutput() {
		return audioOutput;
	}

	/********
	 * setAudioOutput sets the audioOutput for this cassette. 
	 * @param audioOutput
	 */
	public void setAudioOutput(String audioOutput) {
		this.audioOutput = audioOutput;
	}

	/*********
	 * getEndlessLoop returns the endlessLoop value for this cassette. 
	 * @return endlessLoop
	 */
	public String getEndlessLoop() {
		return endlessLoop;
	}

	/*******
	 * setEndlessLoop sets the endlessLoop for this cassette. 
	 * @param endlessLoop
	 */
	public void setEndlessLoop(String endlessLoop) {
		this.endlessLoop = endlessLoop;
	}

}
