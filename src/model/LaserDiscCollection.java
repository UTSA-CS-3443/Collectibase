package model;

public class LaserDiscCollection extends MoviesCollection {
	
	private String encodingFormat; //CAV, CLV, CAA
	private String region;
	private String sides;
	private String cover;
	
	public LaserDiscCollection(String title) {
		super(title);
	}

	public String getEncodingFormat() {
		return encodingFormat;
	}

	public void setEncodingFormat(String encodingFormat) {
		this.encodingFormat = encodingFormat;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSides() {
		return sides;
	}

	public void setSides(String sides) {
		this.sides = sides;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
}
