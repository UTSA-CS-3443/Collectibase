package model;

public class TCGCollection{
	
	private String rarity;
	private String condition;
	private String value;
	private String name;
	
	
	/**
	 * Constructor for TCGCollection
	 * @param name
	 */
	public TCGCollection(String rarity, String condition, String value, String name) {
		setRarity(rarity);
		setCondition(condition);
		setValue(value);
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
