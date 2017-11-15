package model;

/*********
 * A trading card game collection consisting of Yu-Gi-Oh cards.
 * Preset card statistics are card name, type, attack, defense, and 
 * serial number. 
 * 
 * 
 * @author brendatrejo
 *
 */

public class YuGiOhCollection extends TCGCollection {

	private String cardType; 
	private String attack;
	private String defense;
	private String serialNumber; //optional
	
	public YuGiOhCollection(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getDefense() {
		return defense;
	}

	public void setDefense(String defense) {
		this.defense = defense;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
