package model;

/**
 * Template to add cards to a collection for the Magic the Gathering trading
 * card game
 * 
 * debugged by: Gabriel, Jesus, and Travis.
 * @author Travis
 * 
 */
public class MTGCollection extends TCGCollection {

	private String manaCost; // what it takes to play the card.
	private String cardType; // beast, artifact, etc..
	private String cardSet; // nemesis, plainswalker, etc
	private String artistInfo;
	private String powerToughness; // damage and ability to take damage
	private String cardColor; // White, blue, black, red, green, gold, colorless

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public MTGCollection() {
		super("", "", "", "");
		this.manaCost = "";
		this.cardType = "";
		this.cardSet = "";
		this.artistInfo = "";
		this.powerToughness = "";
		this.cardColor = "";
	}

	public MTGCollection(String name, String condition, String rarity, String value, String manaCost, String cardType,
			String cardSet, String artistInfo, String powerToughness, String cardColor) {
		super(name, condition, rarity, value);
		this.manaCost = manaCost;
		this.cardType = cardType;
		this.cardSet = cardSet;
		this.artistInfo = artistInfo;
		this.powerToughness = powerToughness;
		this.cardColor = cardColor;
	}

	//////// Getters and Setters\\\\\\\\
	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardSet() {
		return cardSet;
	}

	public void setCardSet(String cardSet) {
		this.cardSet = cardSet;
	}

	public String getArtistInfo() {
		return artistInfo;
	}

	public void setArtistInfo(String artistInfo) {
		this.artistInfo = artistInfo;
	}

	public String getPowerToughness() {
		return powerToughness;
	}

	public void setPowerToughness(String powerToughness) {
		this.powerToughness = powerToughness;
	}

	public String getCardColor() {
		return cardColor;
	}

	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}

}
