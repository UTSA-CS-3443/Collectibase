package model;


public class VinylCollection extends MusicCollection {

	private String size; 
	private String color;
	private String speed;
	
	public VinylCollection(String artist, String albumName) {
		super(artist, albumName);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

}
