package model;

/*********
 * YuGiohCollection extends TCGCollection and outlines 
 * basic variables needed for a YuGiOh Card Collection.
 * 
 * Name: The name of this YuGiOh Card.
 * Condition: The condition of this YuGiOh Card. 
 * Rarity: The rarity of this YuGiOh Card.
 * Value: The monetary value of this YuGiOh Card.
 * Card Type: The type for this YuGiOh Card (spell, trap, etc.).
 * Attack: The attack value for this YuGiOh Card. 
 * Defense: The defense value for this YuGiOh Card.
 * Serial Number: The serial number for this YuGiOh Card (not all of them have one).
 * 
 * @author Brenda Trejo
 *
 *@debugger Travis Lawson
 */

public class YuGiOhCollection extends TCGCollection {

	private String cardType;
	private String attack; 
	private String defense;
	private String serialNumber; 

	/**
	 * YuGiOhCollection's constructor prepared to handle empty fields. 
	 */
	public YuGiOhCollection() {
		super(" ", " ", " ", " ");
	}

	/**
	 * YuGiOhCollection's constructor prepared to handle fields with values. 
	 * @param rarity
	 * @param condition
	 * @param value
	 * @param name
	 * @param cardType
	 * @param attack
	 * @param defense
	 * @param serialNumber
	 */
	public YuGiOhCollection(String rarity, String condition, String value, String name, String cardType, String attack,
			String defense, String serialNumber) {
		super(name, condition, rarity, value);
		this.cardType = cardType;
		this.attack = attack;
		this.defense = defense;
		this.serialNumber = serialNumber;
	}

	/***
	 * getCardType returns the card type for this YuGiOh Card. 
	 * @return cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * setCardType sets the type for this YuGiOh Card to the specified parameter. 
	 * @param cardType
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * getAttack returns the attack value for this YuGiOh Card.
	 * @return attack
	 */
	public String getAttack() {
		return attack;
	}

	/****
	 * setAttack sets the attack value for this YuGiOh Card to the
	 * specified parameter. 
	 * @param attack
	 */
	public void setAttack(String attack) {
		this.attack = attack;
	}

	/**
	 * getDefense returns the defense value for this YuGiOh Card.
	 * @return defense
	 */
	public String getDefense() {
		return defense;
	}

	/**
	 * setDefense sets the defense value for this YuGiOh Card to the
	 * specified parameter. 
	 * @param defense
	 */
	public void setDefense(String defense) {
		this.defense = defense;
	}

	/**
	 * getSerialNumber returns the serial number for this YuGiOh Card. 
	 * @return serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * setSerialNumber sets the serial number of this YuGiOh Card to
	 * the specified parameter. 
	 * @param serialNumber
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
