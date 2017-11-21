package model;

public class TCGCollection{
	
	private String rarity;
	private String condition;
	private String cardGame; //which TCG: i.e. Pokemon, Magic, etc..
	private double value;
	
	/**
	 * Constructor for TCGCollection
	 * @param name
	 */
	public TCGCollection(String name) {
		setName(name);
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCardGame() {
		return cardGame;
	}

	public void setCardGame(String cardGame) {
		this.cardGame = cardGame;
	}


}
