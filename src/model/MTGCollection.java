package model;

/**
 * MTGCollection extends TCGCollection and outlines the basic variables needed for a 
 * Magic to Gathering Collection. 
 * 
 * Name: The name of this MTG Card. 
 * Condition: The condition of this MTG card. 
 * Rarity: The rarity value of this MTG card. 
 * Value: The monetary value of this MTG card. 
 * ManaCast: What it takes to play the card. 
 * Card Type: Specifies the type of MTG card (beast, artifact, etc.)
 * Card Set:Specifies the set the MTG card is in (nemesis, plainswalker, etc.)
 * Artist Info: Specifies information about the artist who drew the illustration on the card. 
 * Power Toughness: Specifies the damage and ability to take damage. 
 * Card Color: Specifies the color of the MTG card (white, blue, black, colorless, etc.)
 * 
 * @author Travis Lawson
 * 
 * @debugger Gabriel Rosas
 * @debugger Jesus Nieto
 * @debugger Travis Lawson
 * 
 */
public class MTGCollection extends TCGCollection {

	private String manaCost; 
	private String cardType; 
	private String cardSet; 
	private String artistInfo;
	private String powerToughness; 
	private String cardColor; 

	/**
	 * MTGCollection's constructor prepared to handle empty fields. 
	 */
	public MTGCollection() {
		super(" ", " ", " ", " ");
		this.manaCost = " ";
		this.cardType = " ";
		this.cardSet = " ";
		this.artistInfo = " ";
		this.powerToughness = " ";
		this.cardColor = " ";
	}

	/************
	 * MTGCollection's constructor prepared to handle fields with values.
	 * @param name
	 * @param condition
	 * @param rarity
	 * @param value
	 * @param manaCost
	 * @param cardType
	 * @param cardSet
	 * @param artistInfo
	 * @param powerToughness
	 * @param cardColor
	 */
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

	/***********
	 * getManaCost returns the ManaCost for this MTG Card.
	 * @return manaCost
	 */
	public String getManaCost() {
		return manaCost;
	}

	/********
	 * setManaCost sets the ManaCost for this MTG Card to the specified parameter.
	 * @param manaCost
	 */
	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	/**********
	 * getCardType returns the card type for this MTG Card.
	 * @return cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/************
	 * setCardType sets the card type for this MTG Card to the specified parameter. 
	 * @param cardType
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**********
	 * getCardSet returns the card set this MTG Card belongs to. 
	 * @return cardSet
	 */
	public String getCardSet() {
		return cardSet;
	}

	/********
	 * setCardSet sets the card set for this MTG Card to the specified parameter. 
	 * @param cardSet
	 */
	public void setCardSet(String cardSet) {
		this.cardSet = cardSet;
	}

	/********
	 * getArtistInfo returns the artist's information for this MTG Card. 
	 * @return artistInfo
	 */
	public String getArtistInfo() {
		return artistInfo;
	}

	/*********
	 * setArtistInfo sets the artistInfo for this specified MTG Card.
	 * @param artistInfo
	 */
	public void setArtistInfo(String artistInfo) {
		this.artistInfo = artistInfo;
	}

	/***********
	 * getPowerToughness returns this MTG Card's PowerToughness.
	 * @return PowerToughness
	 */
	public String getPowerToughness() {
		return powerToughness;
	}

	/**********
	 * setPowerToughness sets this MTG Card's powerToughness to the specified parameter. 
	 * @param powerToughness
	 */
	public void setPowerToughness(String powerToughness) {
		this.powerToughness = powerToughness;
	}

	/******
	 * getCardColor returns this MTG Card's card color.
	 * @return cardColor
	 */
	public String getCardColor() {
		return cardColor;
	}

	/**************
	 * setCardColor sets this MTG Card's color to the specified parameter. 
	 * @param cardColor
	 */
	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}

}
