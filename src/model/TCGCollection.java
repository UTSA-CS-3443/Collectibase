package model;

/**
 * TCGCollection is the parent class for PokemonCardCollection, YuGiOhCollection, and MTGCollection.
 * This class holds variables that each child class have in common.
 * 
 * @author Travis
 *
 */
public class TCGCollection{
	
	private String rarity; // how rare is a card
	private String condition; // is the card in poor, good, great, mint condition
	private String value; // monitary value of a card
	private String name; // name of a card
	
	
	/**
	 * Constructor
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
	
	////////Getters and Setters\\\\\\\\
	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
