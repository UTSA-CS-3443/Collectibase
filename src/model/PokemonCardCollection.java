package model;

/**
 * 
 * PokemonCardCollection extends TCGCollection and outlines basic variables needed
 * for a Pokemon Card Collection.
 * 
 * Name: The name of this Pokemon Card. 
 * Condition: The condition of this Pokemon Card (New, Mint, Tattered, etc.).
 * Rarity: The rarity of this Pokemon Card (Rare, Very Rare, etc.).
 * Value: The monetary value of this Pokemon Card. 
 * Series: The series of this Pokemon Card. There are sixteen different types of series. 
 * Set: The set this Pokemon Card belongs to (Team Rocket, Fossil, Gym Heroes, etc.).
 * Type: The type of card this Pokemon Card is (Pokemon, Item, Evolution, etc.).
 * 
 * @author Cesar Benavides
 * 
 * @debugger Travis Lawson
 *
 */
public class PokemonCardCollection extends TCGCollection {

	private String series;
	private String set;
	private String type;

	/***** 
	 * PokemonCardCollection's constructor prepared to handle empty fields.
	 */
	public PokemonCardCollection() {
		super(" ", " ", " ", " ");
		this.series = " ";
		this.set = " ";
		this.type = " ";
	}

	/***********************
	 * PokemonCardCollection's constructor prepared to handle fields with values. 
	 * @param rarity
	 * @param condition
	 * @param value
	 * @param name
	 * @param series
	 * @param set
	 * @param type
	 */
	public PokemonCardCollection(String rarity, String condition, String value, String name, String series, String set,
			String type) {
		super(name, condition, rarity, value);
		this.series = series;
		this.set = set;
		this.type = type;
	}

	/********
	 * getSeries returns the series that this Pokemon Card belongs to. 
	 * @return series
	 */
	public String getSeries() {
		return series;
	}

	/************
	 * setSeries sets the series of this Pokemon Card to the specified parameter. 
	 * @param series
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/*******
	 * getSet returns the set that this Pokemon Card belongs to. 
	 * @return set
	 */
	public String getSet() {
		return set;
	}

	/********
	 * setSet sets this Pokemon Card's set to the specified parameter. 
	 * @param set
	 */
	public void setSet(String set) {
		this.set = set;
	}

	/*********
	 * getType returns the type of card this Pokemon Card is. 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/********
	 * setType sets this Pokemon Card's type to the specified parameter. 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

}