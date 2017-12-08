package model;

/**
 * TCGCollection (Trading Card Game) is the parent class for PokemonCardCollection, YuGiOhCollection, and MTGCollection.
 * This class holds variables that each child class have in common.
 * 
 * Name: The name of this trading card. 
 * Condition: The condition of this trading card (New, Mint, Tattered, etc.).
 * Rarity: The rarity of this trading card (Rare, Very Rare, etc.).
 * Value: The monetary value of this trading card. 
 * 
 * @author Travis Lawson
 *
 */
public class TCGCollection{
	
	private String rarity; // how rare is a card
	private String condition; // is the card in poor, good, great, mint condition
	private String value; // monitary value of a card
	private String name; // name of a card
	
	
	/**
	 * TCGCollection's constructor initializes it's variables using the specified
	 * parameters.
	 * 
	 * @param name
	 * @param condition
	 * @param rarity
	 * @param value
	 */
	public TCGCollection(String name, String condition, String rarity, String value) {
		setName(name);
		setCondition(condition);
		setRarity(rarity);
		setValue(value);
		
	}
	
	/*************
	 * getRarity returns the rarity of this Trading Card. 
	 * @return rarity
	 */
	public String getRarity() {
		return rarity;
	}

	/*********
	 * setRarity sets this trading card's rarity to the specified parameter. 
	 * @param rarity
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	/*******
	 * getCondition returns this trading card's condition.
	 * @return condition
	 */
	public String getCondition() {
		return condition;
	}

	/********
	 * setCondition sets
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**********
	 * getValue returns the value of this trading card.
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**********
	 * setValue sets the value of this trading card to the specified parameter. 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/*****
	 * getName returns the name of this trading card.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/*********
	 * setName sets the name of this trading card to the specified parameter. 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


}
