package model;
/****
 * Basic class for a cassette collection. 
 * 
 * Type: Type of material the cassette is made out of. 
 * writeProtection: Whether you have the ability to over write what
 * 		is on the tape.
 * audioOutput: Whether it's Mono or Stereo
 * endlessLoop: Whether the tape plays forever or not, you know. Self explanatory, dude. 
 * 
 * @author Brenda Trejo
 *
 */

public class CassetteCollection extends MusicCollection {
	
	private String type; // Type 1, 2, 3, 4, or other
	private String  writeProtection;
	private String  audioOutput;
	private String endlessLoop;
	
	public CassetteCollection() {

		super("","0","","");
		this.type = "";
		this.writeProtection = "";
		this.audioOutput = "";
		this.endlessLoop = "";
	}
	
	public CassetteCollection(String artist, String albumName, String runningTime, String year, String type, String writeProtection, String audioOutput, String endlessLoop) {
		super(artist, year, albumName, runningTime);
		this.type = type;
		this.writeProtection = writeProtection;
		this.audioOutput = audioOutput;
		this.endlessLoop = endlessLoop;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWriteProtection() {
		return writeProtection;
	}

	public void setWriteProtection(String writeProtection) {
		this.writeProtection = writeProtection;
	}

	public String getAudioOutput() {
		return audioOutput;
	}

	public void setAudioOutput(String audioOutput) {
		this.audioOutput = audioOutput;
	}

	public String getEndlessLoop() {
		return endlessLoop;
	}

	public void setEndlessLoop(String endlessLoop) {
		this.endlessLoop = endlessLoop;
	}

}
