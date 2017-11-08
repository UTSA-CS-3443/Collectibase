package model;

public class LaserDiscCollection extends MoviesCollection {
	
	private String size;
	private String sides;
	private String cover;
	
	public LaserDiscCollection(String title, String year) {
		super(title, year);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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
